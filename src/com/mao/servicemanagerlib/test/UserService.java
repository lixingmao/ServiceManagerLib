package com.mao.servicemanagerlib.test;


public abstract interface UserService {

	public abstract Boolean findPasswordByEmail(String paramString1,
			String paramString2);

	public abstract String getSuperAdminId(String paramString);

	public abstract String login(String paramString1, String paramString2,
			String paramString3);

	public abstract void modifyUserPassword(String paramString1,
			String paramString2, String paramString3);

	public abstract String ologin(String paramString1, String paramString2,
			String paramString3);

	public abstract void updateUserFace(String paramString);

}
