package com.mao.servicemanagerlib.service.util;

public class StringUtils {
	public static String cutLastSign(String paramString1, String paramString2) {
		if (isEmpty(paramString1))
			paramString1 = "";
		do {
			paramString1.substring(0, paramString1.lastIndexOf(paramString2));
		} while (!paramString1.endsWith(paramString2));

		return paramString1;
	}

	public static boolean isEmpty(String paramString) {
		return (paramString == null) || (paramString.trim().length() == 0);
	}


	public static boolean isNotBlank(String paramString){
		if (paramString!= null) {
			return !paramString.equals("");
		}
		return false ;
	}
	
	
	
	
	public static boolean isNotEmpty(String paramString) {
		return !isEmpty(paramString);
	}

	public static Integer stringParseInt(String paramString) {
		StringBuilder localStringBuilder = new StringBuilder(paramString);
		int i = localStringBuilder.indexOf(".");
		if (i != -1)
			localStringBuilder = localStringBuilder.delete(i,
					localStringBuilder.length());
		return Integer.valueOf(Integer.parseInt(localStringBuilder.toString()));
	}
}

/*
 * Location:
 * C:\Users\84743_000\Desktop\浜戠瀛︿範\com.tbc.android.defaults_140052_dex2jar.jar
 * Qualified Name:com.mao.servicemanagerlib.service.util.StringUtils JD-Core Version: 0.6.0
 */