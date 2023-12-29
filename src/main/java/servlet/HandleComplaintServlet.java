package servlet;

import dao.mapper.ComplaintMapper;
import dao.util.SqlSessionFactoryUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Complaint;
import pojo.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "HandleComplaintServlet", value = "/HandleComplaintServlet")
public class HandleComplaintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = UTF-8");

        Integer complaintID = Integer.getInteger(request.getParameter("complaintID"));

        ComplaintMapper mapper = (ComplaintMapper) getMapper(ComplaintMapper.class);
        try {
            mapper.updateStatusByID(complaintID);
            List<Complaint> complaints = mapper.selectAll();
            request.getSession().setAttribute("complaintList",complaints);
            response.setStatus(222);
        }catch (SQLException e){
            response.setStatus(555);
        }
        response.sendRedirect("/200web/dashboard");
    }

    private Object getMapper(Class mapperName) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        Object mapper = sqlSession.getMapper(mapperName);
        return mapper;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
