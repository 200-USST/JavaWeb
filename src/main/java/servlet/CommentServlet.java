package servlet;

import com.google.gson.Gson;
import dao.CommentDao;
import dao.impl.CommentDaoImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.Comment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "CommentServlet", value = "/CommentServlet")
public class CommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = UTF-8");

        Integer discussionID = Integer.getInteger(request.getParameter("discussionID"));
        Integer userID = Integer.getInteger(request.getParameter("userID"));
        String username = request.getParameter("username");
        String content = request.getParameter("content");

        Comment comment = new Comment(null, discussionID, userID, username, content);

        CommentDaoImpl commentDao = new CommentDaoImpl();
        commentDao.insertComment(comment);

        String message = "评论成功";
        request.setAttribute("message",message);
    }
}
