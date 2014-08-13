package com.mao.servicemanagerlib.service.domain;

import com.mao.servicemanagerlib.service.core.Cache;
import com.mao.servicemanagerlib.service.util.StringUtils;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class SdkException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private Object[] args;
	private String errorCode;
	private Throwable exception;
	private Map<String, String> serverDetailCauses = new HashMap();

	public SdkException(String paramString, String[] paramArrayOfString) {
		super(paramString);
		this.errorCode = paramString;
		this.args = paramArrayOfString;
	}

	public SdkException(Throwable paramThrowable, String paramString,
			String[] paramArrayOfString) {
		super(paramString, paramThrowable);
		this.exception = paramThrowable;
		this.errorCode = paramString;
		this.args = paramArrayOfString;
	}

	public void addServerDetailCauses(String paramString1, String paramString2) {
		if (this.serverDetailCauses == null)
			this.serverDetailCauses = new HashMap();
		this.serverDetailCauses.put(paramString1, paramString2);
	}

	public Object[] getArgs() {
		return this.args;
	}

	public Throwable getCause() {
		if (this.exception != null)
			return this.exception.getCause();
		return super.getCause();
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public Throwable getException() {
		return this.exception;
	}

	public String getMessage() {
		return getSimpleMessage();
	}

	public Map<String, String> getServerDetailCauses() {
		if (this.serverDetailCauses == null)
			this.serverDetailCauses = new HashMap();
		return this.serverDetailCauses;
	}

	public String getSimpleMessage() {
		String str = (String) Cache.errorMsgCache.get(this.errorCode);
		if ((this.args != null) && (this.args.length > 0)) {

			if (!StringUtils.isNotBlank(str))
				str = "";
			for (int i = 0; i < this.args.length; i++)
				str = str + this.args[i];
			str = MessageFormat.format(str, this.args);
		}
		return str;
	}

	public void printStackTrace() {
		super.printStackTrace();
	}

	public boolean serverDetailCausesIncludeErrorCode(String paramString) {

		return StringUtils.isNotBlank((String) this.serverDetailCauses
				.get(paramString));
	}

	public void setArgs(String[] paramArrayOfString) {
		this.args = paramArrayOfString;
	}

	public void setErrorCode(String paramString) {
		this.errorCode = paramString;
	}

	public void setException(Throwable paramThrowable) {
		this.exception = paramThrowable;
	}

	public void setServerDetailCauses(Map<String, String> paramMap) {
		this.serverDetailCauses = paramMap;
	}
}

/*
 * Location:
 * C:\Users\84743_000\Desktop\云端学习\com.tbc.android.defaults_140052_dex2jar.jar
 * Qualified Name:com.mao.servicemanagerlib.service.domain.SdkException JD-Core Version: 0.6.0
 */