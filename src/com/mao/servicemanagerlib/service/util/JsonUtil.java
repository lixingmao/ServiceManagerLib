package com.mao.servicemanagerlib.service.util;

import java.lang.reflect.Type;

public class JsonUtil {
	// private static final JsonCodec jsonUtil = new JsonCodec();

	// public static JsonCodec getJsonutil() {
	// return jsonUtil;
	// }

	public static String paramToJson(Object paramObject) {
		if (paramObject == null)
			return "";
		return toJson(paramObject);
	}

	public static String toJson(Object paramObject) {
		// return jsonUtil.toJson(paramObject);
		return null;

	}

	public static <ObjectFactory> ObjectFactory toObject(String paramString) {
		// return (ObjectFactory) jsonUtil.toObject(paramString);
		return null;
	}

	public static <ObjectFactory> ObjectFactory toObject(String paramString,
			Type paramType) {
		// return (ObjectFactory) jsonUtil.toObject(paramString, paramType);
		return null;
	}
}
