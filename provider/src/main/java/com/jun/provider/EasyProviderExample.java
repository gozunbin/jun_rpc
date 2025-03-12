package com.jun.provider;

import com.jun.common.service.UserService;
import com.jun.junrpc.RpcApplication;
import com.jun.junrpc.registry.LocalRegistry;
import com.jun.junrpc.server.HttpServer;
import com.jun.junrpc.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // RPC框架初始化
        RpcApplication.init();

        // 注册服务
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
//        httpServer.doStart(8086);
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
