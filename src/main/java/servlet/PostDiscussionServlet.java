package servlet;

import com.google.gson.Gson;
import dao.mapper.DiscussionMapper;
import dao.util.SqlSessionFactoryUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Discussion;
import pojo.User;
import service.util.SharedService;
import service.util.SharedServiceImpl;

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
import java.util.List;

@WebServlet(name = "PostDiscussionServlet", value = "/PostDiscussionServlet")
public class PostDiscussionServlet extends HttpServlet {
    SharedService sharedService =new SharedServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = UTF-8");
        PrintWriter pw = response.getWriter();

        String title = request.getParameter("title");
        String time0 = request.getParameter("time");
        User user = (User) request.getSession().getAttribute("user");
        Integer userID = user.getId();
        String userName = user.getUserName();
        String content = request.getParameter("content");
//        Part image0 = request.getPart("image0");
        Integer dishID = Integer.getInteger(request.getParameter("dishID"));

        //转化格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = new Date();
        if (time0!=null&&!time0.isEmpty()){
            try {
                time = dateFormat.parse(time0);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        //添加照片时启用
        String imagePath =null;
//        if (image0!=null){
//            //图片保存生成路径
//            imagePath = handleImage(image0);
//            //tes文件存储是否成功
//            System.out.println("imagePath:"+imagePath);
//
//        }
        
        Discussion discussion = new Discussion(null, title, time, userID, userName, content, imagePath, dishID, null);
        
        Gson gson = new Gson();
        try {
            DiscussionMapper dicussionMapper = (DiscussionMapper)getMapper(DiscussionMapper.class);
            dicussionMapper.insertDiscussion(discussion);
//            response.setStatus(200);
            List<Discussion> discussions = dicussionMapper.selectByTimeLimitAscend(5);
            request.getSession().setAttribute("discussionList",discussions);
        } catch (SQLException e) {
            response.setStatus(555);

        }
        response.sendRedirect("/200web/dashboard");
        System.out.println(request.getSession().getAttribute("discussionList"));

    }

    private Object getMapper(Class mapperName) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        Object mapper = sqlSession.getMapper(mapperName);
        return mapper;
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
