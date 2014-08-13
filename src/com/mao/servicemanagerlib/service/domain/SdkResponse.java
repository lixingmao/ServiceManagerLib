package com.mao.servicemanagerlib.service.domain;

import org.apache.http.HttpResponse;

public class SdkResponse {
	private HttpResponse response;
	private Object result;

	public HttpResponse getResponse() {
		return this.response;
	}

	public Object getResult() {
		return this.result;
	}

	public void setResponse(HttpResponse paramHttpResponse) {
		this.response = paramHttpResponse;
	}

	public void setResult(Object paramObject) {
		this.result = paramObject;
	}
}
