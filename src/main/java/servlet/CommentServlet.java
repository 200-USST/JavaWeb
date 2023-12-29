package servlet;

import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.Comment;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CommentServlet", value = "/CommentServlet")
public class CommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = UTF-8");
        PrintWriter pw = response.getWriter();

        String discussionID = request.getParameter("discussionID");
        String userID = request.getParameter("userID");
        String username = request.getParameter("username");
        String content = request.getParameter("content");

        Comment comment = new Comment(null, Integer.getInteger(discussionID), Integer.getInteger(userID), username, content);

        String message;
        Gson gson = new Gson();
//        CommentDaoImpl commentDao = new CommentDaoImpl();
//        commentDao.insertComment(comment);
        message = "评论成功";
        String messageJson = gson.toJson(message);
        pw.write(messageJson);
//        message = "评论失败";
//        String messageJson = gson.toJson(message);
//        pw.write(messageJson);
    }
}
