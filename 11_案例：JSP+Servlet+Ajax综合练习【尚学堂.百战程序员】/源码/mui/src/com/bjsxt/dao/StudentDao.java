package com.bjsxt.dao;

import com.bjsxt.pojo.Student;

import java.util.List;

public interface StudentDao {
    int addStudent(Student student);

    int getTotalCount(String sname, String phone);

    List<Student> getStudentByPage(int start, int size, String sname, String phone);
}
