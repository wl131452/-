package com.bjsxt.dao.impl;

import com.bjsxt.dao.StudentDao;
import com.bjsxt.pojo.Clazz;
import com.bjsxt.pojo.Student;
import com.bjsxt.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public int addStudent(Student s) {
        Connection connection = null;
        PreparedStatement ps = null;
        int i = 0;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into student values(null,?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(sql);

            ps.setString(1, s.getSname());
            ps.setString(2, s.getSex());
            ps.setString(3, s.getHobby());

            long time = s.getBirthdate().getTime();
            Date date = new Date(time);
            ps.setDate(4, date);
            ps.setString(5, s.getPhone());
            ps.setString(6, s.getReamrk());
            ps.setInt(7, s.getCid());

            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(ps, connection);
        }
        return i;
    }

    @Override
    public int getTotalCount(String sname, String phone) {
        Connection connection = null;
        PreparedStatement ps = null;
        int totalCount = 0;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select count(*) count from student where 1=1 ";

            if(sname != null && !sname.equals("")){
                sql += " and sname like '%"+sname+"%'";
            }

            if(phone != null && !phone.equals("")){
                sql += " and phone=" + phone;
            }

            ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            totalCount = 0;
            if(resultSet.next()){
                totalCount = resultSet.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(ps, connection);
        }
        return totalCount;
    }

    @Override
    public List<Student> getStudentByPage(int start, int size, String sname, String phone) {

        Connection connection = null;
        PreparedStatement ps = null;
        List<Student> list = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select s.*, c.cname from student s,clazz c where s.cid=c.cid ";

            if(sname != null && !sname.equals("")){
                sql += " and sname like '%"+sname+"%'";
            }

            if(phone != null && !phone.equals("")){
                sql += " and phone=" + phone;
            }

            sql += " limit ?,?";

            ps = connection.prepareStatement(sql);

            ps.setInt(1, start);
            ps.setInt(2, size);

            ResultSet resultSet = ps.executeQuery();
            list = new ArrayList<>();

            while(resultSet.next()){
                int sid = resultSet.getInt("sid");
                String sname2 = resultSet.getString("sname");
                String sex = resultSet.getString("sex");
                String hobby = resultSet.getString("hobby");
                Date birthdate = resultSet.getDate("birthdate");
                String phone2 = resultSet.getString("phone");
                String reamrk = resultSet.getString("reamrk");
                int cid = resultSet.getInt("cid");
                String cname = resultSet.getString("cname");

                Clazz clazz = new Clazz();
                clazz.setCid(cid);
                clazz.setCname(cname);
                Student student = new Student(sid, sname2, sex, hobby, birthdate, phone2, reamrk, cid, clazz);

                list.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(ps, connection);
        }
        return list;
    }
}
