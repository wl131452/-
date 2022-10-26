package com.bjsxt.service.impl;

import com.bjsxt.dao.StudentDao;
import com.bjsxt.dao.impl.StudentDaoImpl;
import com.bjsxt.pojo.PageBean;
import com.bjsxt.pojo.Student;
import com.bjsxt.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> getAll(String sname, String phone) {
        return studentDao.getStudentByPage(0, Integer.MAX_VALUE, sname, phone);
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public PageBean<Student> getStudentByPage(Integer index, String sname, String phone) {

        PageBean<Student> pageBean = new PageBean<>();
        pageBean.setIndex(index); //设置当前页
        pageBean.setSize(3); //设置每页显示条数

        //调用dao层查询学生的总条数
        int totalCount = studentDao.getTotalCount(sname, phone);
        pageBean.setTotalCount(totalCount); //设置总条数，内部已经设置好了总页码

        //调用dao层获取当前页数据  sele    limit x, x
        List<Student> list = studentDao.getStudentByPage((index-1)*3, 3, sname, phone);
        pageBean.setList(list); //设置当前页的数据

        return pageBean;
    }
}
