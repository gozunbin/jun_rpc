package com.jun.consumer;

import com.jun.common.model.User;
import com.jun.common.service.UserService;
import com.jun.junrpc.config.RpcConfig;
import com.jun.junrpc.proxy.ServiceProxyFactory;
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

        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        // 3。接口Mock
//        UserService userService = MockServiceProxyFactory.getMockProxy(UserService.class);

        User user = new User();
        user.setName("junge");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
//        3。接口Mock
//        short number = userService.getNumber();
//        System.out.println(number);
    }
}
