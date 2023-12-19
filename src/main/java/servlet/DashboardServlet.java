package servlet;

import business.util.SharedService;
import business.util.SharedServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.Canteen;
import pojo.Dish;
import pojo.Info;
import pojo.User;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "dashboardServlet", value = "/dashboard")
public class DashboardServlet extends HttpServlet {
    SharedService sharedService =new SharedServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user!=null){
            Info info = (Info) session.getAttribute("info");
            ArrayList<User> users=new ArrayList<>();
            ArrayList<Canteen> canteens = new ArrayList<>();
            ArrayList<Dish> dishes=new ArrayList<>();
            sharedService.updateAllInfo(users,canteens,dishes);
            session.setAttribute("userList",users);
            session.setAttribute("canteenList",canteens);
            session.setAttribute("dishesList",dishes);
            for(var t : users){
                System.out.println(t.getUserName());
            }
            if(info!=null){

                request.setAttribute("info",info);
                session.removeAttribute("info");
                System.out.println(info.getFlag());
                System.out.println(info.getDescription());
            }
            var user_identity=user.getUserIdentity();
            request.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp").forward(request,response);
        }
        else {
            response.sendRedirect("/200web/login.do");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
