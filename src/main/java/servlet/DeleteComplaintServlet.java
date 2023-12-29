package servlet;

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

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DeleteComplaintServlet", value = "/DeleteComplaintServlet")
public class DeleteComplaintServlet extends HttpServlet {
    SqlSession sqlSession;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = UTF-8");

        Integer complaintID = Integer.parseInt(request.getParameter("complaintID"));

        ComplaintMapper mapper = (ComplaintMapper) getMapper(ComplaintMapper.class);
        try {
            mapper.deleteById(complaintID);
            List<Complaint> complaints = mapper.selectAll();
            request.getSession().setAttribute("allComplains",complaints);
            response.setStatus(222);
        }catch (SQLException e){
            response.setStatus(555);
        }
        sqlSession.close();
        response.sendRedirect("/200web/dashboard");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    private Object getMapper(Class mapperName) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession(true);
        Object mapper = sqlSession.getMapper(mapperName);
        return mapper;
    }
}
