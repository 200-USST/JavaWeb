package servlet;

import business.util.SharedService;
import business.util.SharedServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.Info;
import pojo.User;

import java.io.IOException;

@WebServlet(name = "modifyProfile", value = "/modifyProfile")
public class ModifyProfileServlet extends HttpServlet {
    SharedService sharedService =new SharedServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String userName = request.getParameter("userName");
        String age = request.getParameter("userAge");
        age = age.isBlank() ? null : age;
        String gender = request.getParameter("userGender");
        gender = gender.isBlank() ? null : gender;
        Info info=sharedService.modifyProfile(user,userName,age,gender);
        request.getSession().setAttribute("user",user);
        request.getSession().setAttribute("info",info);
        request.getSession().setAttribute("activeBar",request.getParameter("activeBar"));
        response.sendRedirect("/200web/dashboard");
    }
}
