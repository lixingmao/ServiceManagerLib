package com.mao.servicemanagerlib.service.core;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpResponse;

import com.mao.servicemanagerlib.service.domain.ExceptionResponse;
import com.mao.servicemanagerlib.service.domain.SdkException;
import com.mao.servicemanagerlib.service.domain.SdkRequest;
import com.mao.servicemanagerlib.service.domain.SdkResponse;
import com.mao.servicemanagerlib.service.log.Log;
import com.mao.servicemanagerlib.service.session.SessionContext;
import com.mao.servicemanagerlib.service.util.JsonUtil;
import com.mao.servicemanagerlib.service.util.SdkContext;

/**
 * 动态加载联网Service 的Hanlder操作类
 * 
 * @author mao
 *
 */
public class ServiceHandler implements InvocationHandler {

	/**
	 * 执行对应的接口方法
	 */
	public Object invoke(Object proxy, Method method, Object[] params)
			throws Throwable {
		try {
			SdkRequest request = initRequest(proxy.getClass().getInterfaces()[0]
					.getName() + "." + method.getName());
			request.setParams(params);
			SessionContext.checkSession(request, this);
			Object localObject = getResultByServer(request,
					method.getGenericReturnType());
			return localObject;
		} catch (SdkException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			String[] str = new String[] { e1.getMessage() };
			throw new SdkException(e1, "sdk.future.task.error", str);
		}
		return null;
	}

	/**
	 * 初始化 请求参数
	 * 
	 * @param paramString
	 *            接口名+"."+ 方法名
	 * @return
	 */
	private SdkRequest initRequest(String paramString) {
		SdkRequest sdkRequest = Cache.sdkRequestCache.get(paramString);
		
		if (sdkRequest == null) {
			String[] arrayOfString = new String[2];
			arrayOfString[0] = SdkContext.configApiInAssetsFilePath;
			arrayOfString[1] = paramString;
			throw new SdkException("sdk.metadate.error", arrayOfString);
		}
		
		
		sdkRequest.init();
		return sdkRequest;
	}

	private void openServerHasError(String paramString) {

		// TODO 第二个参数 临时修改为Null 原来是一个 Type 类型
		List localList = (List) JsonUtil.toObject(paramString, null);
		StringBuffer localStringBuffer = new StringBuffer();
		HashMap localHashMap = new HashMap();
		for (int i = 0;; i++) {
			if (i >= localList.size()) {
				SessionContext
						.checkSessionTimeoutAndToLoginActivity(localHashMap);
				String[] arrayOfString = new String[1];
				arrayOfString[0] = localStringBuffer.toString();
				SdkException localSdkException = new SdkException(
						"sdk.open.server.error", arrayOfString);
				localSdkException.addServerDetailCauses("status_code", "200");
				localSdkException.getServerDetailCauses().putAll(localHashMap);
				throw localSdkException;
			}
			ExceptionResponse localExceptionResponse = (ExceptionResponse) localList
					.get(i);
			String str = "errorCode:" + localExceptionResponse.getErrorCode()
					+ ",cause:" + localExceptionResponse.getCause() + ";";
			localStringBuffer.append(str);
			localStringBuffer.append("\n");
			localHashMap.put(localExceptionResponse.getErrorCode(), str);
		}
	}

	public Object getResultByServer(SdkRequest paramSdkRequest, Type paramType) {
		HttpResponse localHttpResponse = HttpServer
				.doHttpRequest(paramSdkRequest);
		if (localHttpResponse == null)
			;
		SdkResponse localSdkResponse;
		do {
			localSdkResponse = formatResult(paramType, paramSdkRequest,
					localHttpResponse);
		} while (localSdkResponse == null);
		return localSdkResponse.getResult();
	}

	private SdkResponse formatResult(Type paramType,
			SdkRequest paramSdkRequest, HttpResponse paramHttpResponse) {
		SdkResponse localSdkResponse;
		if ((paramType == null) || (paramHttpResponse == null))
			localSdkResponse = null;
		String str;
		do {
			localSdkResponse = new SdkResponse();
			localSdkResponse.setResponse(paramHttpResponse);
			byte[] arrayOfByte = HttpServer.parseResponse(localSdkResponse);
			if ((arrayOfByte == null) || (arrayOfByte.length == 0))
				return null;
			try {
				str = new String(arrayOfByte, SdkContext.encod);
				if (paramHttpResponse.getStatusLine().getStatusCode() != 200) {
					SdkException localSdkException = new SdkException(
							"sdk.open.server.error", new String[] { str });
					localSdkException.addServerDetailCauses("status_code",
							paramHttpResponse.getStatusLine().getStatusCode()
									+ "");
					throw localSdkException;
				}
			} catch (UnsupportedEncodingException localUnsupportedEncodingException) {
				String[] arrayOfString = new String[1];
				arrayOfString[0] = SdkContext.encod;
				throw new SdkException(localUnsupportedEncodingException,
						"sdk.encoding.param.failed", arrayOfString);
			}
			if (Boolean.parseBoolean(paramHttpResponse
					.getFirstHeader("hasException").getValue().toString())) {
				openServerHasError(str);
				return null;
			}
			if (SdkContext.logShowInConsole)
				Log.debug(ServiceHandler.class.getName(), "请求URL["
						+ paramSdkRequest.getServerUrl() + "]返回的结果如下：\n" + str);
			if (!SdkContext.logWriteToFile)
				continue;
			Log.writeLog("请求URL[" + paramSdkRequest.getServerUrl()
					+ "]返回的结果如下：\n" + str);
		} while (("null".equalsIgnoreCase(str)) || (paramType == Void.TYPE));
		localSdkResponse.setResult(JsonUtil.toObject(str, paramType));

		return localSdkResponse;
	}
}