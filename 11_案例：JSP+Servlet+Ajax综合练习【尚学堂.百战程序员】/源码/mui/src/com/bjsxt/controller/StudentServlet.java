package com.bjsxt.controller;

import com.bjsxt.pojo.PageBean;
import com.bjsxt.pojo.Student;
import com.bjsxt.service.StudentService;
import com.bjsxt.service.impl.StudentServiceImpl;
import com.bjsxt.utils.ExcelOperate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/StudentServlet")
public class StudentServlet extends BaseServlet {

    private StudentService studentService = new StudentServiceImpl();

    protected void exportStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置响应的数据类型
        resp.setContentType("application/vnd.ms-excel");
        //设置不要打开内容，以下载的方式去展示
        resp.setHeader("Content-disposition", "attachment; fileName=" + new String(("学生表.xls").getBytes(), "iso8859-1"));

        //获取搜索条件
        String sname = req.getParameter("sname");
        String phone = req.getParameter("phone");

        List<Student> list = studentService.getAll(sname, phone);

        //将list集合中的数据写入到一个Excel文件中，并且将这个文件响应给客户端浏览器
        ExcelOperate.createExcel(list, resp.getOutputStream());
    }

    //分页查询
    protected void getStudentByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        //获取到请求中第几页这个参数
        String index = req.getParameter("index");

        //获取搜索条件
        String sname = req.getParameter("sname");
        String phone = req.getParameter("phone");


        //调用service进行分页查询，返回组装好的分页对象
        PageBean<Student> pageBean = studentService.getStudentByPage(Integer.parseInt(index), sname, phone);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String s = gson.toJson(pageBean);
        resp.getWriter().write(s);
    }

    protected void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String sname = req.getParameter("sname");
        String sex = req.getParameter("sex");

        String[] hobbies = req.getParameterValues("hobby");
        //[aaa,aaa,aa]    aaa,aaa,aaa

        String hobby = String.join(",", hobbies);

        String birthdateStr = req.getParameter("birthdate");

        Date birthdate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            birthdate = sdf.parse(birthdateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String phone = req.getParameter("phone");
        int cid = Integer.parseInt(req.getParameter("cid"));
        String reamrk = req.getParameter("reamrk");

        Student student = new Student(null, sname, sex, hobby, birthdate, phone, reamrk, cid, null);
        int i = studentService.addStudent(student);

        resp.getWriter().write(i > 0 ? "1" : "0");
    }
}
