package web;
import model.Volunteer;
import services.VolunteerServices;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet("/selectAllServlet")
public class selectAllServlet extends HttpServlet {

    private VolunteerServices service = new VolunteerServices();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        List<Volunteer> volunteers = service.selectAll();
        HttpSession session = request.getSession();
        session.setAttribute("volunteers",volunteers);
        response.sendRedirect("selectAll.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }
}
