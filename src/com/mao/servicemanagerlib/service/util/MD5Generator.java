package com.mao.servicemanagerlib.service.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Generator {
	private static final String CHARSET = "UTF-8";
	private static char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56,
			57, 65, 66, 67, 68, 69, 70 };
	private static final String MD5 = "MD5";
	private MessageDigest digest;

	public MD5Generator() {
		try {
			this.digest = MessageDigest.getInstance("MD5");
			return;
		} catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
		}
	}

	public static String getHexMD5(String paramString) {
		try {
			MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
			localMessageDigest.update(paramString.getBytes("UTF-8"));
			String str = hexDigest(localMessageDigest.digest());
			return str;
		} catch (Exception localException) {
		}
		return null;
	}

	public static String hexDigest(byte[] paramArrayOfByte) {
		char[] arrayOfChar = new char[2 * paramArrayOfByte.length];
		for (int i = 0;; i++) {
			if (i >= paramArrayOfByte.length)
				return new String(arrayOfChar);
			arrayOfChar[(i * 2)] = HEX_DIGITS[(0xF & paramArrayOfByte[i] >> 4)];
			arrayOfChar[(1 + i * 2)] = HEX_DIGITS[(0xF & paramArrayOfByte[i])];
		}
	}

	public String getHexMD5() {
		return hexDigest(this.digest.digest());
	}

	public byte[] getMD5() {
		return this.digest.digest();
	}

	public void update(byte[] paramArrayOfByte) {
		if (paramArrayOfByte == null)
			return;
		update(paramArrayOfByte, 0, paramArrayOfByte.length);
	}

	public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
		if ((this.digest == null) || (paramArrayOfByte == null))
			return;
		this.digest.update(paramArrayOfByte, paramInt1, paramInt2);
	}
}

/*
 * Location:
 * C:\Users\84743_000\Desktop\云端学习\com.tbc.android.defaults_140052_dex2jar.jar
 * Qualified Name:com.mao.servicemanagerlib.service.util.MD5Generator JD-Core Version: 0.6.0
 */