package com.bjsxt.service.impl;

import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.impl.UserDaoImpl;
import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String ukey, String pwd) {
        return userDao.getUserByUkeyAndPwd(ukey, pwd);
    }
}
