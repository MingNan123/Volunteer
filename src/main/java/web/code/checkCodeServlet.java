package web.code;

import services.CheckCodeUtil;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 22541
 */
@WebServlet(name = "checkCodeServlet", urlPatterns = "/checkCodeServlet")
public class checkCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");*/
        ServletOutputStream outputStream = response.getOutputStream();
        String checkCode = CheckCodeUtil.outputVerifyImage(100, 50, outputStream, 4);
        //doPost(request, response);
        HttpSession session = request.getSession();
        session.setAttribute("checkCodeGen",checkCode);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        //this.doGet(request, response);
    }
}
