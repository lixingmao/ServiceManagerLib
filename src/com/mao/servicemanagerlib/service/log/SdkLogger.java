package com.mao.servicemanagerlib.service.log;

public abstract interface SdkLogger
{
  public abstract void debug(String paramString);

  public abstract void debug(String paramString1, String paramString2);

  public abstract void error(String paramString1, String paramString2, Throwable paramThrowable);

  public abstract void error(String paramString, Throwable paramThrowable);

  public abstract void error(Throwable paramThrowable);

  public abstract String getExcetionMsg(Throwable paramThrowable);

  public abstract void warn(String paramString);

  public abstract void warn(String paramString1, String paramString2);

  public abstract void writeLog(String paramString);

  public abstract void writeLog(String paramString, Throwable paramThrowable);
}

/* Location:           C:\Users\84743_000\Desktop\云端学习\com.tbc.android.defaults_140052_dex2jar.jar
 * Qualified Name:    com.mao.servicemanagerlib.service.log.SdkLogger
 * JD-Core Version:    0.6.0
 */