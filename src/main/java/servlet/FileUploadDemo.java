package servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.util.FileUpload;
import service.util.Rc;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/fileUpload")//ROOT用户的一些操作控制层代码
public class FileUploadDemo extends HttpServlet {
    FileUpload fileUpload =new FileUpload();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(403);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String realPath1 = "C:\\Users\\15520\\IdeaProjects\\JavaWebApp\\src\\main\\webapp\\data\\dish_pics";
        String realPath2 = "C:\\Users\\15520\\IdeaProjects\\JavaWebApp\\src\\main\\webapp\\data\\dish_picstmp";
        try {
            fileUpload.fileUpload(req,realPath1,realPath2,"pinG");
        } catch (FileUploadException e) {
            throw new RuntimeException(e);
        }
        System.out.println("here");
    }
}