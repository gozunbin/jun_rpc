package com.jun.consumer;


import com.jun.common.model.User;
import com.jun.common.service.UserService;
import com.jun.junrpc.proxy.ServiceProxyFactory;

/**
 * 简易服务消费者示例
 */
public class EasyConsumerExample {

    public static void main(String[] args) {
        // todo 需要获取 UserService 的实现类对象
        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);

        User user = new User();
        user.setName("junge");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}
