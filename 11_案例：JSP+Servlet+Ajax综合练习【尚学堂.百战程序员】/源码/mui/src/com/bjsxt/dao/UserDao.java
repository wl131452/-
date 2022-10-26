package com.bjsxt.dao;

import com.bjsxt.pojo.User;

public interface UserDao {

    User getUserByUkeyAndPwd(String ukey, String pwd);
}
