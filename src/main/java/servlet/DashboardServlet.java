package servlet;

import service.util.SharedService;
import service.util.SharedServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.Canteen;
import pojo.Dish;
import pojo.Info;
import pojo.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            Map<String, Canteen> manager_canteen_pair = new HashMap<>();
            StringBuilder canteen_manager_json = new StringBuilder();
            Map<String, List<Dish>> canteen_dishes_dict = new HashMap<>();
            sharedService.updateAllInfo(users,canteens,dishes, manager_canteen_pair, canteen_manager_json, canteen_dishes_dict);
            session.setAttribute("userList",users);
            session.setAttribute("canteenList",canteens);
            session.setAttribute("dishesList",dishes);
            session.setAttribute("mcMap", manager_canteen_pair);
            session.setAttribute("cmJson", canteen_manager_json.toString());
            session.setAttribute("cdMap", canteen_dishes_dict);
            if(info!=null){
                request.setAttribute("info",info);
                session.removeAttribute("info");
                System.out.println(info.getFlag());
                System.out.println(info.getDescription());
            }
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
