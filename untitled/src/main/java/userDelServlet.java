import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "userDelServlet", value = "/userDelServlet")
public class userDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int result=0;
        PrintWriter out=null;
        UserDao dao=new UserDao();
        String userName=request.getParameter("cname");
        String password=request.getParameter("cteacher");
        Integer userId=Integer.parseInt(request.getParameter("ukey"));
        Users user =new Users(userId,userName,password);
        result=dao.del(user);
        response.setContentType("text/html;charset=utf-8");
        out=response.getWriter();
        if(result==1){
            out.print("<font style='color:red;font-size:40'>用户信息删除成功!</font>");
        }
        else {
            out.print("<font style='color:red;font-size:40'>用户信息删除失败!</font>");
        }

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
