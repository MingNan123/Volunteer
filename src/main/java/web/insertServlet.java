package web;

import model.Volunteer;
import services.VolunteerServices;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
@WebServlet("/insertServlet")
public class insertServlet extends HttpServlet {
    private VolunteerServices service = new VolunteerServices();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        int vtId = Integer.parseInt(request.getParameter("vtId"));
        String vtSno = request.getParameter("vtSno");
        String vtName = request.getParameter("vtName");
        String vtRegion = request.getParameter("vtRegion");
        String vtStartTime = request.getParameter("vtStartTime");
        String vtDuration = request.getParameter("vtDuration");
        String vtStatus = request.getParameter("vtStatus");
        Volunteer volunteer = new Volunteer(vtId,vtSno,vtName,vtRegion,vtStartTime,vtDuration,vtStatus);
        //2. 调用service 完成添加
        service.insert(volunteer);
        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }
}
