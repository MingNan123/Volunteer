package web;

import model.User;
import services.UserServices;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 22541
 */
@WebServlet(name = "loginServlet", urlPatterns = "/loginServlet")
public class loginServlet extends HttpServlet {
    private UserServices service = new UserServices();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        boolean flag = true;
        User user = service.login(username, password);
        if (user != null) {
            //将登陆成功后的user对象，存储到session
            HttpSession session = request.getSession();
            String checkCodeGen = (String) session.getAttribute("checkCodeGen");
            if (!checkCodeGen.equalsIgnoreCase(checkCode)) {
                request.setAttribute("error", "验证码错误!");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                return;
            }
            session.setAttribute("user", user);
            System.out.println(user.getUsername());
            String contextPath = request.getContextPath();
            response.sendRedirect("main.jsp");
        } else {
            // 登录失败,
            // 存储错误信息到request
            request.setAttribute("error", "用户名或密码错误");
            // 跳转到login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }
}
