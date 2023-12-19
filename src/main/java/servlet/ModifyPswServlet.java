package servlet;

import business.util.SharedService;
import business.util.SharedServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.Info;
import pojo.User;

import java.io.IOException;

@WebServlet(name = "modifyPsw", value = "/modifyPsw")
public class ModifyPswServlet extends HttpServlet {
    SharedService sharedService =new SharedServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String oldPsw = "szp123123";
        String newPsw = "szp1231234";
        String newPswRepeat = "szp1231234";
        Info info=sharedService.modifyPassword(user,oldPsw,newPsw,newPswRepeat);
        request.getSession().setAttribute("info",info);
        response.sendRedirect("/200web/dashboard");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String oldPsw = request.getParameter("oldPsw");
        String newPsw = request.getParameter("newPsw");
        String newPswRepeat = request.getParameter("newPswRepeat");
        Info info=sharedService.modifyPassword(user,oldPsw,newPsw,newPswRepeat);
        request.getSession().setAttribute("user",user);
        request.getSession().setAttribute("info",info);
        response.sendRedirect("/200web/dashboard");
    }
}