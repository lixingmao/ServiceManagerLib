package com.mao.servicemanagerlib.service.core;

import com.mao.servicemanagerlib.service.domain.SdkRequest;
import java.util.HashMap;
import java.util.Map;

public class Cache {
	public static Map<String, String> errorMsgCache = new HashMap<String, String>();
	public static Map<String, SdkRequest> sdkRequestCache = new HashMap<String, SdkRequest>();
}