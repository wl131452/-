package com.bjsxt.dao.impl;

import com.bjsxt.dao.ClazzDao;
import com.bjsxt.pojo.Clazz;
import com.bjsxt.pojo.TongJi;
import com.bjsxt.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClazzDaoImpl implements ClazzDao {
    @Override
    public List<TongJi> getTongJi() {
        Connection connection = null;
        PreparedStatement ps = null;
        List<TongJi> list = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select count(*) count,c.cname from student s,clazz c where s.cid=c.cid group by c.cname";
            ps = connection.prepareStatement(sql);

            ResultSet resultSet = ps.executeQuery();

            list = new ArrayList<>();
            while(resultSet.next()){
                int count = resultSet.getInt("count");
                String cname = resultSet.getString("cname");

                TongJi tongJi = new TongJi(cname, count);

                list.add(tongJi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(ps, connection);
        }
        return list;
    }

    @Override
    public int updateClazz(Clazz c) {
        Connection connection = null;
        PreparedStatement ps = null;
        int i = 0;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "update clazz set cname=?,cteacher=?,remark=? where cid=?";
            ps = connection.prepareStatement(sql);

            ps.setString(1, c.getCname());
            ps.setString(2, c.getCteacher());
            ps.setString(3, c.getRemark());
            ps.setInt(4, c.getCid());

            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(ps, connection);
        }
        return i;
    }

    @Override
    public List<Clazz> getClazzByPage(int start, int size) {
        Connection connection = null;
        PreparedStatement ps = null;
        List<Clazz> list = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from clazz limit ?,?";
            ps = connection.prepareStatement(sql);

            ps.setInt(1, start);
            ps.setInt(2, size);

            ResultSet resultSet = ps.executeQuery();

            list = new ArrayList<>();
            while(resultSet.next()){
                int cid = resultSet.getInt("cid");
                String cname = resultSet.getString("cname");
                String cteacher = resultSet.getString("cteacher");
                String remark = resultSet.getString("remark");

                Clazz clazz = new Clazz(cid, cname, cteacher, remark);
                list.add(clazz);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(ps, connection);
        }
        return list;
    }

    @Override
    public int getTotalCount() {
        Connection connection = null;
        PreparedStatement ps = null;
        int totalCount = 0;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select count(*) from clazz";
            ps = connection.prepareStatement(sql);

            ResultSet resultSet = ps.executeQuery();
            totalCount = 0;
            if(resultSet.next()){
                totalCount = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(ps, connection);
        }
        return totalCount;
    }

    @Override
    public List<Clazz> getAll() {
        Connection connection = null;
        PreparedStatement ps = null;
        List<Clazz> list = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from clazz";
            ps = connection.prepareStatement(sql);

            ResultSet resultSet = ps.executeQuery();

            list = new ArrayList<>();

            while(resultSet.next()){
                int cid = resultSet.getInt("cid");
                String cname = resultSet.getString("cname");
                String cteacher = resultSet.getString("cteacher");
                String remark = resultSet.getString("remark");
                Clazz clazz = new Clazz(cid, cname, cteacher, remark);

                list.add(clazz);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(ps, connection);
        }
        return list;
    }

    @Override
    public int addClazz(Clazz clazz) {
        Connection connection = null;
        PreparedStatement ps = null;
        int i = 0;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into clazz values(null,?,?,?)";
            ps = connection.prepareStatement(sql);

            ps.setString(1, clazz.getCname());
            ps.setString(2, clazz.getCteacher());
            ps.setString(3, clazz.getRemark());

            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(ps, connection);
        }
        return i;
    }
}
