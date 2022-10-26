import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "userAddServlet", value = "/",urlPatterns = "/user/add")
public class userAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                //1.调用请求对象
                //2.调用UserDao
                //3.调用响应对象
                //tomcat负责销毁请求对象和响应对象，并将http响应协议发送到请求的浏览器上
                int result=0;
                PrintWriter out=null;
                UserDao dao=new UserDao();
                String userName=request.getParameter("cname");
                String password=request.getParameter("cteacher");
                Users user =new Users(userName,password);
                result=dao.add(user);
                response.setContentType("text/html;charset=utf-8");
                out=response.getWriter();
                if(result==1){
                    out.print("<font style='color:red;font-size:40'>用户信息注册成功!</font>");
                }
                else {
                    out.print("<font style='color:red;font-size:40'>用户信息注册失败!</font>");
                }

        }
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

