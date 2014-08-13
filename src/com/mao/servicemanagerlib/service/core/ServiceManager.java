package com.mao.servicemanagerlib.service.core;

import java.lang.reflect.Proxy;

/**
 * 通过动态代理的方式, 加载声明对应方法的接口实例
 * 
 * @author mao
 *
 */
public class ServiceManager {
	@SuppressWarnings("unchecked")
	public static <AnyService> AnyService getService(Class<AnyService> pClass)
			throws Exception {

		if ((pClass == null) || (!pClass.isInterface())) {
			return null;
		} else {
			return (AnyService) Proxy.newProxyInstance(Thread.currentThread()
					.getContextClassLoader(), new Class[] { pClass },
					new ServiceHandler());
		}
	}
}