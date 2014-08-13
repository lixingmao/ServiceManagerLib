package com.mao.servicemanagerlib.service.util;

public class SdkInit {
	public void initSdk() {
		ConfigUtils localConfigUtils = new ConfigUtils();
		localConfigUtils.initConfig();
		localConfigUtils.initErrorMsg();
		localConfigUtils.initOpenApiMetadata();
	}
}

/*
 * Location:
 * C:\Users\84743_000\Desktop\云端学习\com.tbc.android.defaults_140052_dex2jar.jar
 * Qualified Name:com.mao.servicemanagerlib.service.util.SdkInit JD-Core Version: 0.6.0
 */