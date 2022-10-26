package com.bjsxt.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// http://localhost:8080/项目名/HelloServlet?id=5&methodName=delete
@WebServlet("/HelloServlet")
public class HelloServlet extends BaseServlet {

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    protected void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
