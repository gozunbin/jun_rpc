package com.jun.junrpc.proxy;

import com.jun.junrpc.RpcApplication;

import java.lang.reflect.Proxy;

/**
 * 服务代理工厂（用于创建 Mock 代理对象）
 */
public class MockServiceProxyFactory {


    /**
     * 3。根据服务类获取 Mock 代理对象
     * @param serviceClass
     * @return
     * @param <T>
     */
    public static <T> T getMockProxy(Class<T> serviceClass) {
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new MockServiceProxy());
    }
}
