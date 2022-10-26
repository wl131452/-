import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userLoginServlet")
public class userLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=null;
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("ukey");
        String password = request.getParameter("pwd");
        System.out.print(userName);
//        String code = request.getParameter("code");

        //判断验证码对不对
        //获取正确的验证码
//        String str = (String) request.getSession().getAttribute("randStr");

//        if(code != null && code.equals(str)){//验证码正确
//            //判断用户名和密码对不对
//            UserDao dao=new UserDao();
//            Users user =dao.Login(userName,password);
//
//            if(user == null){//登录失败
//                response.getWriter().write("1");
//            }else{//登录成功
//                request.getSession().setAttribute("user", user);
//                response.getWriter().write("2");
//            }
//
//        }else{//验证码不正确
//            response.getWriter().write("0");
//
//        }
//    }


    //判断用户名和密码对不对
    UserDao dao = new UserDao();

    Users user = dao.Login(userName,password);
    out=response.getWriter();
    if(user ==null)
    {//登录失败
//        response.getWriter().write("1");
            response.sendRedirect("http://localhost:8080/untitled_war_exploded/login_error.html");
    }else

    {//登录成功
        request.getSession().setAttribute("user", user);
//        response.getWriter().write("2");
        response.sendRedirect("http://localhost:8080/untitled_war_exploded/login_success.html");
    }

}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

