package web;
import model.User;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author 22541
 */
@WebServlet(name = "registerServlet", urlPatterns = "/registerServlet")
public class registerServlet extends HttpServlet {
    private UserServices service = new UserServices();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //封装用户对象
        User user =new User();
        user.setUsername(username);
        user.setPassword(password);
        service.add(user);
        boolean flag = true;
        //3. 判断注册成功与否
        if(flag){
            //注册功能，跳转登陆页面
            request.setAttribute("error","注册成功，请登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            //注册失败，跳转到注册页面
            request.setAttribute("error","用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }
}
