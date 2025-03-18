package com.jun.provider;

import com.jun.common.service.UserService;
import com.jun.junrpc.RpcApplication;
import com.jun.junrpc.config.RegistryConfig;
import com.jun.junrpc.config.RpcConfig;
import com.jun.junrpc.model.ServiceMetaInfo;
import com.jun.junrpc.registry.LocalRegistry;
import com.jun.junrpc.registry.Registry;
import com.jun.junrpc.registry.RegistryFactory;
import com.jun.junrpc.server.HttpServer;
import com.jun.junrpc.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class ProviderExample {

    public static void main(String[] args) {
        // RPC框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName,UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        // 2。全局配置对象加载
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
