package com.mao.servicemanagerlib.service.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

import com.mao.servicemanagerlib.service.domain.SdkException;
import com.mao.servicemanagerlib.service.domain.SdkRequest;
import com.mao.servicemanagerlib.service.domain.SdkResponse;
import com.mao.servicemanagerlib.service.log.Log;
import com.mao.servicemanagerlib.service.util.SdkContext;
import com.mao.servicemanagerlib.service.util.StringUtils;

/**
 * 联网工具类
 * 
 * @author mao
 *
 */
public class HttpServer {

	/**
	 * 执行一次服务器请求. 默认 利用Post连接
	 * 
	 * @param req
	 * @return
	 */
	protected static HttpResponse doHttpRequest(SdkRequest req) {
		String str1 = req.getServerUrl();
		HttpPost post = new HttpPost(str1);
		String str2 = getPostParam(req.getParams());
		try {
			StringEntity localStringEntity = new StringEntity(str2,
					SdkContext.encod);
			post.setEntity(localStringEntity);
			log(str1, str2);
			return doHttpRequest(post, req);
		} catch (UnsupportedEncodingException e) {
			throw new SdkException(e, "sdk.encoding.param.failed",
					new String[] { SdkContext.encod });
		}

	}

	protected static HttpResponse doHttpRequest(final HttpUriRequest post,
			SdkRequest sdkRequest) {
		if (post == null)
			return null;

		ExecutorService executorService = Executors.newCachedThreadPool();

		FutureTask<HttpResponse> task = new FutureTask<HttpResponse>(
				new Callable<HttpResponse>() {
					@Override
					public HttpResponse call() throws Exception {
						BasicHttpParams params = new BasicHttpParams();
						HttpConnectionParams.setConnectionTimeout(params,
								SdkContext.connectionTimeout);
						HttpConnectionParams.setSoTimeout(params,
								SdkContext.soTimeout);
						DefaultHttpClient httpClient = new DefaultHttpClient(
								params);
						try {
							HttpResponse response = httpClient.execute(post);
							return response;
						} catch (ClientProtocolException localClientProtocolException) {
							throw new SdkException(
									localClientProtocolException,
									"sdk.http.request.failed", new String[0]);
						} catch (IOException localIOException) {
							throw new SdkException(localIOException,
									"sdk.http.request.failed", new String[0]);
						}
					}
				});

		executorService.submit(task);

		try {
			HttpResponse response = task.get();
			return response;
		} catch (InterruptedException e) {
			throw new SdkException(e, "sdk.http.request.failed", new String[0]);
		} catch (ExecutionException e1) {
			throw new SdkException(e1, "sdk.http.request.failed", new String[0]);
		}
	}

	/**
	 * 获取 SDKRequest 中的参数信息, 并组织称 post所需的参数形式
	 * 
	 * @param paramMap
	 * @return
	 */
	private static String getPostParam(Map<String, String> paramMap) {
		StringBuffer sb = new StringBuffer();
		Iterator<Entry<String, String>> iterator = paramMap.entrySet()
				.iterator();

		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();

			sb.append(entry.getKey());
			sb.append("=");
			if (StringUtils.isNotBlank(entry.getValue())) {
				try {
					sb.append(URLEncoder.encode(entry.getValue(),
							SdkContext.encod));
					sb.append("&");
				} catch (UnsupportedEncodingException e) {
					Log.error(HttpServer.class.getName(),
							"将[" + (String) entry.getValue() + "]使用编码["
									+ SdkContext.encod + "]做URLEncoder时出错！", e);
				}
			}
		}
		return StringUtils.cutLastSign(sb.toString(), "&");

	}

	/**
	 * 每次请求的日志, 根据配置. 打印或者保存文件
	 * 
	 * @param url
	 * @param params
	 */
	private static void log(String url, String params) {
		try {
			if (SdkContext.logShowInConsole)
				Log.debug(
						HttpServer.class.getName(),
						"开始发送请求,请求的URL如下：\n" + url + "?"
								+ URLDecoder.decode(params, SdkContext.encod));
			if (SdkContext.logWriteToFile)
				Log.writeLog("开始发送请求,请求的URL如下：\n" + url + "?" + params);
		} catch (UnsupportedEncodingException e) {
			Log.error(HttpServer.class.getName(), "将[" + params + "]使用编码["
					+ SdkContext.encod + "]做URLDecoder时出错！", e);
		}
	}

	/**
	 * 解析 收到的Response 信息
	 * 
	 * @param sdkResponse
	 * @return
	 */
	protected static byte[] parseResponse(SdkResponse sdkResponse) {
		HttpResponse res = sdkResponse.getResponse();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		HttpEntity localHttpEntity = res.getEntity();
		if (localHttpEntity == null)
			return null;
		try {
			InputStream is = localHttpEntity.getContent();
			byte[] arrayOfByte = new byte[SdkContext.tempBuffSize];
			int i = 0;
			while ((i = is.read(arrayOfByte)) != -1) {
				outputStream.write(arrayOfByte, 0, i);
			}
			return outputStream.toByteArray();
		} catch (IllegalStateException localIllegalStateException) {
			throw new SdkException(localIllegalStateException,
					"sdk.parse.response.error", new String[0]);
		} catch (IOException localIOException) {
			throw new SdkException(localIOException,
					"sdk.parse.response.error", new String[0]);
		}
	}
}
