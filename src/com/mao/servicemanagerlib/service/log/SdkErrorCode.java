package com.mao.servicemanagerlib.service.log;

public abstract interface SdkErrorCode
{
  public static final String ENCODING_PARAM_FAILED = "sdk.encoding.param.failed";
  public static final String ENCODING_RESULT_FAILED = "sdk.encoding.result.failed";
  public static final String FUTURE_TASK_ERROR = "sdk.future.task.error";
  public static final String HTTP_REQUEST_FAILED = "sdk.http.request.failed";
  public static final String INVALID_INTERFACE = "sdk.use.invalid.interface";
  public static final String OPEN_SERVER_ERROR = "sdk.open.server.error";
  public static final String PARAM_NOT_NULL = "sdk.use.param.not.null";
  public static final String PARSE_RESPONSE_ERROR = "sdk.parse.response.error";
  public static final String SDK_ERROR_PREFIX = "sdk.error.prefix";
  public static final String SDK_METADATE_ERROR = "sdk.metadate.error";
  public static final String SERVICE_INSTANCE_FAILED = "sdk.service.instance.failed";
  public static final String UNKNOWN_FILE = "sdk.use.unknown.file";
}

/* Location:           C:\Users\84743_000\Desktop\云端学习\com.tbc.android.defaults_140052_dex2jar.jar
 * Qualified Name:    com.mao.servicemanagerlib.service.log.SdkErrorCode
 * JD-Core Version:    0.6.0
 */