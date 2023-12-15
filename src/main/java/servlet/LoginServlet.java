package servlet;

import business.util.SharedService;
import business.util.SharedServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.User;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login.do")
public class LoginServlet extends HttpServlet {
    SharedService sharedService = new SharedServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("userPassword");
        User user = sharedService.login(userName,password);
        if(user!=null){
            System.out.println(userName);
            System.out.println("1");
        }
        else System.out.println("2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
