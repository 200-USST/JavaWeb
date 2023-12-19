package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.Info;
import pojo.User;

import java.io.IOException;

@WebServlet(name = "dashboardServlet", value = "/dashboard")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user!=null){
            Info info = (Info) session.getAttribute("info");
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