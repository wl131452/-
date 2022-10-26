package com.bjsxt.controller;

import com.bjsxt.pojo.Clazz;
import com.bjsxt.pojo.PageBean;
import com.bjsxt.pojo.TongJi;
import com.bjsxt.service.ClazzService;
import com.bjsxt.service.impl.ClazzServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ClazzServlet")
public class ClazzServlet extends BaseServlet {

    private ClazzService clazzService = new ClazzServiceImpl();

    //统计班级人数
    protected void getTongJi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        List<TongJi> list = clazzService.getTongJi();

        Gson gson = new Gson();
        String s = gson.toJson(list);

        resp.getWriter().write(s);
    }

    //修改班级
    protected void updateClazz(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String cid = req.getParameter("cid");
        String cname = req.getParameter("cname");
        String cteacher = req.getParameter("cteacher");
        String remark = req.getParameter("remark");

        Clazz clazz = new Clazz(Integer.parseInt(cid), cname, cteacher, remark);

        int i = clazzService.updateClazz(clazz);

        resp.getWriter().write(i > 0 ? "true" : "false");
    }

    //添加班级
    protected void addClazz(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String cname = req.getParameter("cname");
        String cteacher = req.getParameter("cteacher");
        String remark = req.getParameter("remark");

        Clazz clazz = new Clazz(null, cname, cteacher, remark);

        int i = clazzService.addClazz(clazz);

        resp.getWriter().write(i > 0 ? "1" : "0");
    }

    //查询所有班级信息
    protected void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        List<Clazz> list = clazzService.getAll();

        Gson gson = new Gson();
        String s = gson.toJson(list);

        resp.getWriter().write(s);
    }

    //分页查询
    protected void getClazzByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        //接收要第几页的数据
        String index = req.getParameter("index");

        PageBean<Clazz> pageBean = clazzService.getClazzByPage(Integer.parseInt(index));

        Gson gson = new Gson();
        String s = gson.toJson(pageBean);

        resp.getWriter().write(s);
    }
}
