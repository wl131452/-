package com.bjsxt.dao.impl;
import com.bjsxt.dao.UserDao;
import com.bjsxt.pojo.User;
import com.bjsxt.utils.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUserByUkeyAndPwd(String ukey, String pwd) {
        Connection connection = null;
        PreparedStatement ps = null;
        User user = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from user where ukey=? and pwd=?";
            ps = connection.prepareStatement(sql);

            ps.setString(1, ukey);
            ps.setString(2, pwd);

            ResultSet resultSet = ps.executeQuery();

            user = null;
            if(resultSet.next()){
                int uid = resultSet.getInt("uid");
                String realname = resultSet.getString("realname");
                int type = resultSet.getInt("type");

                user = new User(uid, ukey, pwd, realname, type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(ps, connection);
        }

        return user;
    }
}
