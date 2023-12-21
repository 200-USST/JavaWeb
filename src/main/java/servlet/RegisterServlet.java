package servlet;

import service.admin.AdminService;
import service.admin.AdminServiceImpl;
import service.user.UserService;
import service.user.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.Info;

import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/register.do")
public class RegisterServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    AdminService adminService =new AdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if(type.equals("user")){//注册普通用户
            String userName = request.getParameter("userName");
            String password = request.getParameter("userPassword");
            String passwordRe = request.getParameter("userPasswordRepeat");
            Info info = userService.register(userName,password,passwordRe);
            System.out.println(info.getFlag()+" "+info.getDescription());
            response.sendRedirect("/200web/login.do");
        }
        else if(type.equals("manager")){//注册管理员用户
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
