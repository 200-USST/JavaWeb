package servlet;

import dao.mapper.ComplaintMapper;
import dao.mapper.DiscussionMapper;
import dao.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.*;
import pojo.*;
import service.util.SharedService;
import service.util.SharedServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "dashboardServlet", value = "/dashboard")
public class DashboardServlet extends HttpServlet {
    SharedService sharedService =new SharedServiceImpl();
    SqlSession sqlSession;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user!=null){
            Info info = (Info) session.getAttribute("info");
            ArrayList<User> users=new ArrayList<>();
            ArrayList<Canteen> canteens = new ArrayList<>();
            StringBuilder id_canteen=new StringBuilder();
            Map<String, Canteen> manager_canteen_pair = new HashMap<>();
            StringBuilder canteen_manager_json = new StringBuilder();
            Map<String, List<Dish>> canteen_dishes_dict = new HashMap<>();

            List<Complaint> complaints;
            List<Discussion> discussions;
            List<Complaint> allComplaints;
            ComplaintMapper complaintMapper = (ComplaintMapper)getMapper(ComplaintMapper.class);
            DiscussionMapper discussionMapper = (DiscussionMapper)getMapper(DiscussionMapper.class);
            try {
                complaints = complaintMapper.selectAllById(user.getId());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                allComplaints = complaintMapper.selectAll();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                discussions = discussionMapper.selectAll();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            sqlSession.close();


            StringBuilder canteen_dishes_json = new StringBuilder();
            sharedService.updateAllInfo(users,canteens,id_canteen, manager_canteen_pair, canteen_manager_json, canteen_dishes_dict, canteen_dishes_json);
            session.setAttribute("userList",users);
            session.setAttribute("canteenList",canteens);
            session.setAttribute("icJson",id_canteen);
            session.setAttribute("mcMap", manager_canteen_pair);
            session.setAttribute("cmJson", canteen_manager_json.toString());
            session.setAttribute("cdMap", canteen_dishes_dict);
            session.setAttribute("cdJson", canteen_dishes_json);
            session.setAttribute("complaintList",complaints);
            session.setAttribute("discussionList",discussions);
            session.setAttribute("allComplaints",allComplaints);


            if(info!=null){
                request.setAttribute("info",info);
                session.removeAttribute("info");
            }
            request.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp").forward(request,response);
        }
        else {
            response.sendRedirect("/200web/login.do");
        }
    }
    private Object getMapper(Class mapperName) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession(true);
        Object mapper = sqlSession.getMapper(mapperName);
        return mapper;
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
