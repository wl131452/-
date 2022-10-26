import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;



@WebServlet(name = "userFindAllServlet", value = "/userFindAllServlet")
public class userFindAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                UserDao dao= new UserDao();
                PrintWriter  out;
                List<Users>userList=dao.findAll();
                response.setContentType("text/html;charset=utf-8");
                out=response.getWriter();
                out.print("<table borde='2' align='center'>");
                out.print("<tr>");
                out.print("<td>用户编号</td>");
                out.print("<td>用户名</td>");
                out.print("<td>用户密码</td>");
                out.print("</tr>");
                for(Users user:userList){
                    out.print("<tr>");
                    out.print("<td>"+user.getUserId()+"</td>");
                    out.print("<td>"+user.getUserName()+"</td>");
                    out.print("<td>******</td>");
                    out.print("</tr>");
                }
                out.print("</table>");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
