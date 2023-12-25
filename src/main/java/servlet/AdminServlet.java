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
        request.getSession().setAttribute("activeBar",request.getParameter("activeBar"));
        if(request.getParameter("type").equals("deleteCanteen")){
            String originalPath = getServletContext().getRealPath("/");
            int targetIndex = originalPath.indexOf("target");
            String basePath = originalPath.substring(0, targetIndex);
            String realPath1 = basePath + "src\\main\\webapp\\data\\dish_pics";
            String canteenId = request.getParameter("canteenId");
            String canteenPic = request.getParameter("canteenPic");
            Info info = adminService.deleteCanteen(canteenId,canteenPic,realPath1);
            request.getSession().setAttribute("info",info);
            response.sendRedirect("/200web/dashboard");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("activeBar",request.getParameter("activeBar"));
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
            response.sendRedirect("/200web/dashboard");
        }
        else if(request.getParameter("type").equals("modifyCanteen")){
            String originalPath = getServletContext().getRealPath("/");
            int targetIndex = originalPath.indexOf("target");
            String basePath = originalPath.substring(0, targetIndex);
            String realPath1 = basePath + "src\\main\\webapp\\data\\dish_pics";
            String realPath2 = basePath + "src\\main\\webapp\\data\\dish_picstmp";
            Info info;
            try {
                info = adminService.modifyCanteen(request,realPath1,realPath2);
            } catch (FileUploadException e) {
                throw new RuntimeException(e);
            }
            request.getSession().setAttribute("info",info);
            response.sendRedirect("/200web/dashboard");
        }
    }
}
