package servlet;

import service.canteenAdmin.ManagerService;
import service.canteenAdmin.ManagerServiceImpl;
import service.util.SharedService;
import service.util.SharedServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojo.User;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login.do")
public class LoginServlet extends HttpServlet {
    SharedService sharedService = new SharedServiceImpl();
    ManagerService managerService = new ManagerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login-register.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("userPassword");
        User user = sharedService.login(userName,password);
        String path = getServletContext().getRealPath("/data/dish_pics");
        System.out.println(path);
        if(user!=null){
            HttpSession session = request.getSession(true);
            session.setAttribute("user",user);
            if(user.getUserIdentity().equals("manager")){
                session.setAttribute("canteen",managerService.findCanteen(user));
            }
            response.sendRedirect("/200web/dashboard");
        }
        else {
            response.sendRedirect("/200web/login.do");
        }
    }
}
