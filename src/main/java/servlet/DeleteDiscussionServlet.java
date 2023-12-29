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
import pojo.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "DeleteDiscussionServlet", value = "/DeleteDiscussionServlet")
public class DeleteDiscussionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = UTF-8");

        Integer discussionID = Integer.getInteger(request.getParameter("discussionID"));

        DiscussionMapper mapper = (DiscussionMapper) getMapper(DiscussionMapper.class);
        try {
            mapper.deleteByID(discussionID);
            List<Discussion> discussions = mapper.selectAll();
            request.getSession().setAttribute("discussionList",discussions);
            response.setStatus(222);
        }catch (SQLException e){
            response.setStatus(555);
        }
        response.sendRedirect("/200web/dashboard");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    private Object getMapper(Class mapperName) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        Object mapper = sqlSession.getMapper(mapperName);
        return mapper;
    }
}
