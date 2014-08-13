package com.mao.servicemanagerlib.service.session;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import com.mao.servicemanagerlib.service.core.ServiceHandler;
import com.mao.servicemanagerlib.service.domain.SdkRequest;
import com.mao.servicemanagerlib.service.util.SdkContext;
import java.util.Date;
import java.util.Map;

/**
 * Session 控制类
 * 
 * @author mao
 *
 */
public class SessionContext {
	private static long lastLoginTime = new Date().getTime();

	/**
	 * 检查 Session 是否失效
	 * 
	 * @return
	 */
	public static boolean checkLoaclSessionIsTimeOut() {
		return new Date().getTime() - lastLoginTime < SdkContext.sessionTimeout;
	}

	public static void checkSession(SdkRequest paramSdkRequest,
			ServiceHandler paramServiceHandler) {
		if (SdkContext.sessionAutoMaintain) {
			if (!paramSdkRequest.getUri().equalsIgnoreCase(
					SdkContext.sessionLoginRequestUri))
				if (!checkLoaclSessionIsTimeOut())
					SdkContext.sessionlastLoginUserRequest = paramSdkRequest;
		}
		while (true) {
			lastLoginTime = new Date().getTime();
			SdkContext.sessionlastLoginUserRequest.refreshTimestamp();
			Object localObject = paramServiceHandler.getResultByServer(
					SdkContext.sessionlastLoginUserRequest, String.class);
			SdkContext.attributes.put("session_", localObject.toString());
			paramSdkRequest.changeSession(localObject.toString());
		}
	}

	/**
	 * Session 失效, 发送广播, 通知跳转登录界面
	 * @param paramMap
	 * @return
	 */
	@SuppressLint({ "ShowToast" })
	public static boolean checkSessionTimeoutAndToLoginActivity(
			Map<String, String> paramMap) {
		Object localObject = paramMap.get(SdkContext.sessionExpiredErrorCode);
		if (localObject != null) {
			Intent intent = new Intent();
			intent.setAction(SdkContext.SESSION_EXPIRED_INTENT_ACTION);
			SdkContext.context.sendBroadcast(intent);
			return true;
		}
		return false;
	}
}
