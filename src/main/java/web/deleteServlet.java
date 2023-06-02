package web;

import services.VolunteerServices;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author 22541
 */
@WebServlet(name = "deleteServlet", urlPatterns = "/deleteServlet")
public class deleteServlet extends HttpServlet {
    private final VolunteerServices service = new VolunteerServices();
    private static final String ACTION_DEL = "delete";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String vtId = request.getParameter("vtId");
        service.deleteById(Integer.parseInt(vtId));
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }
}
