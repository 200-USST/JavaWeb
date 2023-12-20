package servlet;

import com.google.gson.Gson;
import dao.impl.CommentDaoImpl;
import dao.impl.DiscussionDaoImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.Comment;
import pojo.Discussion;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet(name = "PostDiscussionServlet", value = "/PostDiscussionServlet")
public class PostDiscussionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = UTF-8");
        PrintWriter pw = response.getWriter();

        String title = request.getParameter("title");
        String time0 = request.getParameter("time");
        Integer userID = Integer.getInteger(request.getParameter("userID"));
        String userName = request.getParameter("userName");
        String content = request.getParameter("content");
        Part image0 = request.getPart("image0");
        Integer dishID = Integer.getInteger(request.getParameter("dishID"));

        //转化格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = new Date();
        try {
            time = dateFormat.parse(time0);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //图片保存生成路径
        String imagePath = handleImage(image0);
        //tes文件存储是否成功
        System.out.println("imagePath:"+imagePath);
        Discussion discussion = new Discussion(null, title, time, userID, userName, content, imagePath, dishID, null);

        String message;
        Gson gson = new Gson();
        try {
            DiscussionDaoImpl discussionDao = new DiscussionDaoImpl();
            discussionDao.insertDiscussion(discussion);
            message = "发布成功";
            String messageJson = gson.toJson(message);
            pw.write(messageJson);
        } catch (SQLException e) {
            message = "发布失败";
            String messageJson = gson.toJson(message);
            pw.write(messageJson);
        }
    }

    private String handleImage(Part image0) {
        Path filePath = null;
        // 获取文件名
        String fileName = getFileName(image0);

        // 获取服务器上的保存路径，你可以根据需求更改路径
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";

        // 创建目录（如果不存在）
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // 将文件写入服务器
        try (InputStream input = image0.getInputStream()) {
            filePath = Paths.get(uploadPath, fileName);
            Files.copy(input, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String imagePath = filePath.toString();
        return imagePath;
    }

    // 获取文件名
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
