package servlet;

import business.admin.AdminService;
import business.admin.AdminServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.Info;

import java.io.IOException;

@WebServlet(name = "adminServlet", value = "/adminServlet")//ROOT用户的一些操作控制层代码
public class AdminServlet extends HttpServlet {
    AdminService adminService=new AdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("addCanteen")!=null){
            String canteenName=request.getParameter("canteenName");
            String canteenLocation=request.getParameter("canteenLocation");
            String canteenAbstract=request.getParameter("canteenAbstract");
            Info info=adminService.newCanteen(canteenName,canteenLocation,canteenAbstract);
            request.getSession().setAttribute("info",info);
            System.out.println(info.getDescription());
            response.sendRedirect("/200web/dashboard");
        }
    }
}
