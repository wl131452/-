package com.bjsxt.service;

import com.bjsxt.pojo.User;

public interface UserService {
    User login(String ukey, String pwd);
}
