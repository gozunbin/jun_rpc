package com.jun.consumer;


import com.jun.common.model.User;
import com.jun.common.service.UserService;
import com.jun.junrpc.proxy.MockServiceProxyFactory;
import com.jun.junrpc.proxy.ServiceProxyFactory;

/**
 * 简易服务消费者示例
 */
public class EasyConsumerExample {

    public static void main(String[] args) {
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
        short number = userService.getNumber();
        System.out.println(number);
    }
}
