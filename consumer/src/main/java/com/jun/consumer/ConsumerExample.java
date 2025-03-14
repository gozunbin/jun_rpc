package com.jun.consumer;

import com.jun.junrpc.config.RpcConfig;
import com.jun.junrpc.utils.ConfigUtils;

/**
 * 扩展服务消费者示例
 * 测试配置文件读取，通过修改配置文件，可以动态改变端口
 */
public class ConsumerExample {

    public static void main(String[] args) {
        // 2。配置文件读取
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
//        RpcConfig rpc = ConfigLoader.loadConfig(RpcConfig.class, "rpc");  // 扩展
        System.out.println(rpc);
    }
}
