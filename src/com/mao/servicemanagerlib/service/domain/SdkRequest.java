package com.mao.servicemanagerlib.service.domain;

import android.annotation.SuppressLint;

import com.mao.servicemanagerlib.service.util.JsonUtil;
import com.mao.servicemanagerlib.service.util.MD5Generator;
import com.mao.servicemanagerlib.service.util.SdkContext;
import com.mao.servicemanagerlib.service.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 定制的 httpRequest 实例, 包含服务器请求的相关的相关参数信息
 * 
 * @author mao
 *
 */
public class SdkRequest {
	private String ServiceName;
	private String methodName;
	private Map<String, String> attributes = new HashMap<String, String>();

	private Map<Integer, String> paramKeys = new HashMap<Integer, String>() ;
	private Map<String, String> params = new HashMap<String, String>();
	private String uri;

	@SuppressLint({ "DefaultLocale" })
	public void init() {
		clean();
		attributes.put("appKey_", SdkContext.openServerAppKey);
		String str1 = MD5Generator.getHexMD5(
				SdkContext.openServerAppSecret + "|" + getUri() + "|"
						+ SdkContext.openServerAppSecret).toUpperCase();
		attributes.put("sign_", str1);
		Iterator<Entry<String, Object>> iterator = SdkContext.attributes
				.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry<String, Object> localEntry = iterator.next();
			String str2 = localEntry.getKey();
			String str3 = JsonUtil.paramToJson(localEntry.getValue());
			attributes.put(str2, str3);
		}
		// 增加 当前请求时间参数
		refreshTimestamp();
	}

	public void setParams(Object[] objs) {
		if ((objs == null) || (objs.length <= 0))
			return;
		Map<Integer, String> localMap = getParamKeys();

		for (int i = 0; i < objs.length; i++) {
			Object localObject = objs[i];
			if (localObject != null) {
				String str = JsonUtil.paramToJson(localObject);
				if (StringUtils.isEmpty(str))
					continue;
				params.put(localMap.get(i), str);
			}
		}
	}
	
	public void changeSession(String paramString) {
		attributes.put("session_", paramString);
	}

	public void clean() {
		attributes.clear();
		params.clear();
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public String getMethodName() {
		return methodName;
	}

	public Map<Integer, String> getParamKeys() {
		return paramKeys;
	}

	public Map<String, String> getParams() {
		params.putAll(attributes);
		return params;
	}

	public String getServerUrl() {
		return "http://" + SdkContext.openServerName + "/open" + getUri()
				+ ".html";
	}

	public String getServiceName() {
		return ServiceName;
	}

	public String getUri() {
		return uri;
	}

	public void refreshTimestamp() {
		attributes.put("timestamp_", new Date().getTime() + "");
	}

	public void setAttributes(Map<String, String> paramMap) {
		attributes = paramMap;
	}

	public void setMethodName(String paramString) {
		methodName = paramString;
	}

	public void setParamKeys(Map<Integer, String> paramMap) {
		paramKeys = paramMap;
	}

	public void setServiceName(String paramString) {
		ServiceName = paramString;
	}

	public void setUri(String paramString) {
		uri = paramString;
	}
}
