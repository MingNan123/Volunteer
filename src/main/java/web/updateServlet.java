package web;

import model.Volunteer;
import services.VolunteerServices;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    private VolunteerServices service = new VolunteerServices();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
            //1. 接收表单提交的数据
            String  vtId= request.getParameter("vtId");
            String vtSno = request.getParameter("vtSno");
            String vtName = request.getParameter("vtName");
            String vtRegion = request.getParameter("vtRegion");
            String vtStartTime = request.getParameter("vtStartTime");
            String vtDuration = request.getParameter("vtDuration");
            String vtStatus = request.getParameter("vtStatus");
            //封装为一个对象
            Volunteer volunteer  = new Volunteer();
            volunteer.setVtId(Integer.parseInt(vtId));
            volunteer.setVtSno(vtSno);
            volunteer.setVtName(vtName);
            volunteer.setVtRegion(vtRegion);
            volunteer.setVtStartTime(vtStartTime);
            volunteer.setVtDuration(vtDuration);
            volunteer.setVtStatus(vtStatus);
            //2. 调用service 完成修改
            service.update(volunteer);
            System.out.println(volunteer);
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
