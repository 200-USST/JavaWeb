package servlet;

import com.google.gson.Gson;
import dao.mapper.ComplaintMapper;
import dao.mapper.DiscussionMapper;
import dao.util.SqlSessionFactoryUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Complaint;
import pojo.Discussion;
import pojo.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "PostComplaintServlet", value = "/PostComplaintServlet")
public class PostComplaintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = UTF-8");

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        User user = (User) request.getSession().getAttribute("user");
        Integer userID = user.getId();
        Date date = new Date();

        Complaint complaint = new Complaint(null, userID, title, content, date, false);
        ComplaintMapper mapper = (ComplaintMapper) getMapper(ComplaintMapper.class);
        try {
            mapper.insertNewComplaint(complaint);
            List<Complaint> complaints = mapper.selectAllById(userID);
            request.getSession().setAttribute("complaintList",complaints);
//            response.setStatus(200);
        }catch (SQLException e){
            response.setStatus(555);
        }
        request.getSession().setAttribute("activeBar",request.getParameter("activeBar"));
        System.out.println("complaint:"+request.getSession().getAttribute("complaintList"));

        response.sendRedirect("/200web/dashboard");
        System.out.println("complaint:"+request.getSession().getAttribute("complaintList"));
    }

    private Object getMapper(Class mapperName) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        Object mapper = sqlSession.getMapper(mapperName);
        return mapper;
    }
}
