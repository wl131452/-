package com.bjsxt.controller;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import com.bjsxt.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String ukey = req.getParameter("ukey");
        String pwd = req.getParameter("pwd");
        String code = req.getParameter("code");

        //判断验证码对不对
        //获取正确的验证码
        String str = (String) req.getSession().getAttribute("randStr");

        if(code != null && code.equals(str)){//验证码正确
            //判断用户名和密码对不对
            UserService userService = new UserServiceImpl();
            User u = userService.login(ukey, pwd);

            if(u == null){//登录失败
                resp.getWriter().write("1");
            }else{//登录成功
                req.getSession().setAttribute("user", u);
                resp.getWriter().write("2");
            }

        }else{//验证码不正确
            resp.getWriter().write("0");
        }
    }
}
