package com.mao.servicemanagerlib.service.util;

import android.content.Context;
import com.mao.servicemanagerlib.service.core.Cache;
import com.mao.servicemanagerlib.service.domain.SdkRequest;
import com.mao.servicemanagerlib.service.log.SdkLogger;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SdkContext {
	public static String SESSION_EXPIRED_INTENT_ACTION;
	public static Map<String, Object> attributes;
	public static String configApiInAssetsFilePath;
	public static String configAppInAssetsFilePath;
	public static String configErrorMsgInAssetsFilePath;
	public static int connectionTimeout;
	public static Context context;
	public static String encod;
	public static SdkLogger log;
	public static boolean logShowInConsole;
	public static boolean logWriteToFile;
	public static String openServerAppKey = "";
	public static String openServerAppSecret = "";
	public static String openServerName;
	public static String openServerUrl = "";
	public static String openServerVersion;
	public static boolean sessionAutoMaintain;
	public static String sessionExpiredErrorCode;
	public static String sessionLoginRequestUri;
	public static int sessionTimeout;
	public static SdkRequest sessionlastLoginUserRequest;
	public static int soTimeout;
	public static int tempBuffSize;

	static {
		openServerName = "";
		openServerVersion = "";
		attributes = new HashMap<String, Object>();
		connectionTimeout = 5000;
		soTimeout = 180000;
		tempBuffSize = 4096;
		encod = "UTF-8";
		configApiInAssetsFilePath = "sdk" + File.separator + "metadata";
		configAppInAssetsFilePath = "sdk" + File.separator
				+ "config.properties";
		configErrorMsgInAssetsFilePath = "sdk" + File.separator
				+ "error_msg_zh_cn.properties";
		sessionAutoMaintain = true;
		sessionTimeout = 360000;
		sessionLoginRequestUri = "/v1/uc/login/ologin";
		sessionExpiredErrorCode = "open.session.expired";
		SESSION_EXPIRED_INTENT_ACTION = "session_expired_intent_action";
		log = null;
		logShowInConsole = true;
		logWriteToFile = false;
	}

	public static void cleanCache() {
		Cache.sdkRequestCache.clear();
	}
}