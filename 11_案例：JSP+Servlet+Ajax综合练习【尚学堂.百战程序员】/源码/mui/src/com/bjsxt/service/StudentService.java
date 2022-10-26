package com.bjsxt.service;

import com.bjsxt.pojo.PageBean;
import com.bjsxt.pojo.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll(String sname, String phone);

    int addStudent(Student student);

    PageBean<Student> getStudentByPage(Integer index, String sname, String phone);
}
