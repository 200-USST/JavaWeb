package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.Dish;
import service.user.UserService;
import service.user.UserServiceImpl;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "user", value = "/user")
public class UserServlet extends HttpServlet {
    UserService userService =new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("activeBar",request.getParameter("activeBar"));
        if(request.getParameter("type").equals("queryDishesByOrder")){
            String order = request.getParameter("order");
            String value = request.getParameter("value");
            ArrayList<Dish> dishes=new ArrayList<>();
            userService.queryDishesByorder(order,value,dishes);
            request.getSession().setAttribute("orderedDishesList",dishes);
        }
        response.sendRedirect("/200web/dashboard");
    }
}
