package servlet;

import business.admin.AdminService;
import business.admin.AdminServiceImpl;
import business.user.UserService;
import business.user.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.Info;
import pojo.User;

import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/register.do")
public class RegisterServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    AdminService adminService =new AdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if(type.equals("user")){
            String userName = request.getParameter("userName");
            String password = request.getParameter("userPassword");
            String passwordRe = request.getParameter("userPasswordRepeat");
            Info info = userService.register(userName,password,passwordRe);
            System.out.println(info.getFlag()+" "+info.getDescription());
        }
        else if(type.equals("manager")){
            String userName = request.getParameter("userName");
            String password = request.getParameter("userPassword");
            String passwordRe = request.getParameter("userPasswordRepeat");
            String canteenName = request.getParameter("canteenName");
            Info info = adminService.distributeCanteenAdmin(userName,password,passwordRe,canteenName);
        }


    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
