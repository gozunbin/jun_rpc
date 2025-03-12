package com.jun.provider;

import com.jun.common.model.User;
import com.jun.common.service.UserService;


/**
 * 用户服务实现类
 */
public class UserServiceImpl implements UserService {

    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
