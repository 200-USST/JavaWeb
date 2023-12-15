package servlet;

import business.user.UserService;
import business.user.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.User;

import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/register.do")
public class RegisterServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("userPassword");
        String passwordRe = request.getParameter("userPasswordRepeat");
        System.out.println(userService.register(userName,password,passwordRe));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
