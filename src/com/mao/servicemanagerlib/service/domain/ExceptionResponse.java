package com.mao.servicemanagerlib.service.domain;

public class ExceptionResponse
{
  private String cause;
  private String errorCode;

  public ExceptionResponse()
  {
  }

  public ExceptionResponse(String paramString1, String paramString2)
  {
    this.cause = paramString2;
    this.errorCode = paramString1;
  }

  public String getCause()
  {
    return this.cause;
  }

  public String getErrorCode()
  {
    return this.errorCode;
  }

  public void setCause(String paramString)
  {
    this.cause = paramString;
  }

  public void setErrorCode(String paramString)
  {
    this.errorCode = paramString;
  }
}

/* Location:           C:\Users\84743_000\Desktop\云端学习\com.tbc.android.defaults_140052_dex2jar.jar
 * Qualified Name:    com.mao.servicemanagerlib.service.domain.ExceptionResponse
 * JD-Core Version:    0.6.0
 */