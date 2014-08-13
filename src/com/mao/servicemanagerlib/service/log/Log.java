package com.mao.servicemanagerlib.service.log;

import com.mao.servicemanagerlib.service.util.SdkContext;

public class Log
{
  private static String commonTarget = "com.tbc.android.sdk";

  public static void debug(String paramString)
  {
    if (SdkContext.log != null)
      SdkContext.log.debug(commonTarget, paramString);
  }

  public static void debug(String paramString1, String paramString2)
  {
    if (SdkContext.log != null)
      SdkContext.log.debug(paramString1, paramString2);
  }

  public static void error(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (SdkContext.log != null)
      SdkContext.log.error(paramString1, paramString2, paramThrowable);
  }

  public static void error(String paramString, Throwable paramThrowable)
  {
    if (SdkContext.log != null)
      SdkContext.log.error(paramString, "", paramThrowable);
  }

  public static void error(Throwable paramThrowable)
  {
    if (SdkContext.log != null)
      SdkContext.log.error(commonTarget, "", paramThrowable);
  }

  public static String getExcetionMsg(Throwable paramThrowable)
  {
    if (SdkContext.log != null)
      return SdkContext.log.getExcetionMsg(paramThrowable);
    return "";
  }

  public static void warn(String paramString)
  {
    if (SdkContext.log != null)
      SdkContext.log.warn(commonTarget, paramString);
  }

  public static void warn(String paramString1, String paramString2)
  {
    if (SdkContext.log != null)
      SdkContext.log.warn(paramString1, paramString2);
  }

  public static void writeLog(String paramString)
  {
    if (SdkContext.log != null)
      SdkContext.log.writeLog(paramString);
  }

  public static void writeLog(String paramString, Throwable paramThrowable)
  {
    if (SdkContext.log != null)
      SdkContext.log.writeLog(paramString, paramThrowable);
  }
}

/* Location:           C:\Users\84743_000\Desktop\云端学习\com.tbc.android.defaults_140052_dex2jar.jar
 * Qualified Name:    com.mao.servicemanagerlib.service.log.Log
 * JD-Core Version:    0.6.0
 */