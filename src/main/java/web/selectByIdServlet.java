package web;

import model.Volunteer;
import services.VolunteerServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "selectByIdServlet", urlPatterns = "/selectByIdServlet")
public class selectByIdServlet extends HttpServlet {
    private VolunteerServices service = new VolunteerServices();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String vtId = request.getParameter("vtId");
        //2. 调用service查询
        Volunteer volunteer = service.getById(Integer.parseInt(vtId));
        //3. 存储到request中
        request.setAttribute("volunteer",volunteer);
        //4. 转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request,response);
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }
}
