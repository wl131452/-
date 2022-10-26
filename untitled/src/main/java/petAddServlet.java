import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "petAddServlet", value = "/petAddServlet")
public class petAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //tomcat负责销毁请求对象和响应对象，并将http响应协议发送到请求的浏览器上
        int result=0;
        PrintWriter out=null;
        UserDao dao=new UserDao();
        Integer master=Integer.parseInt(request.getParameter("master"));
        String petName=request.getParameter("cname");
        String pet_type=request.getParameter("cteacher");
        Pets pet =new Pets(petName,pet_type,master);
        result=dao.addPets(pet);
        response.setContentType("text/html;charset=utf-8");
        out=response.getWriter();
        if(result==1){
            out.print("<font style='color:red;font-size:40'>宠物信息注册成功!</font>");
        }
        else {
            out.print("<font style='color:red;font-size:40'>宠物信息注册失败!</font>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
