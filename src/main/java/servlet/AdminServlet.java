package servlet;

import org.apache.commons.fileupload.FileUploadException;
import pojo.Canteen;
import service.admin.AdminService;
import service.admin.AdminServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.Info;

import java.io.IOException;

@WebServlet(name = "adminServlet", value = "/adminServlet")//ROOT用户的一些操作控制层代码
public class AdminServlet extends HttpServlet {
    AdminService adminService=new AdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("type").equals("addCanteen")){
            String originalPath = getServletContext().getRealPath("/");
            int targetIndex = originalPath.indexOf("target");
            String basePath = originalPath.substring(0, targetIndex);
            String realPath1 = basePath + "src\\main\\webapp\\data\\canteen_pics";
            String realPath2 = basePath + "src\\main\\webapp\\data\\canteen_picstmp";
            Info info;
            try {
                info = adminService.newCanteen(request,realPath1,realPath2);
            } catch (FileUploadException e) {
                throw new RuntimeException(e);
            }
            request.getSession().setAttribute("info",info);
            request.getSession().setAttribute("activeBar",request.getParameter("activeBar"));
            response.sendRedirect("/200web/dashboard");
        }
    }
}
