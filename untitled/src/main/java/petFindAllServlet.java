import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "petFindAllServlet", value = "/petFindAllServlet")
public class petFindAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao= new UserDao();
        PrintWriter out;
        List<Pets> petList=dao.petfindAll();
        response.setContentType("text/html;charset=utf-8");
        out=response.getWriter();
        out.print("<table borde='2' align='center'>");
        out.print("<tr>");
        out.print("<td>宠物名</td>");
        out.print("<td>品种</td>");
        out.print("<td>主人编号</td>");
        out.print("</tr>");
        for(Pets pet:petList){
            out.print("<tr>");
            out.print("<td>"+pet.getPetName()+"</td>");
            out.print("<td>"+pet.getPet_type()+"</td>");
            out.print("<td>"+pet.getMaster()+"</td>");
            out.print("</tr>");
        }
        out.print("</table>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
