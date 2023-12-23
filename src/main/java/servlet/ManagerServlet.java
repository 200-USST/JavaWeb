package servlet;

import org.apache.commons.fileupload.FileUploadException;
import service.canteenAdmin.ManagerService;
import service.canteenAdmin.ManagerServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.Canteen;
import pojo.Info;
import java.io.IOException;


@WebServlet(name = "manager", value = "/manager")
public class ManagerServlet extends HttpServlet {
    ManagerService managerService =new ManagerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("activeBar",request.getParameter("activeBar"));
        if(request.getParameter("type").equals("deleteDish")){
            String originalPath = getServletContext().getRealPath("/");
            int targetIndex = originalPath.indexOf("target");
            String basePath = originalPath.substring(0, targetIndex);
            String realPath1 = basePath + "src\\main\\webapp\\data\\dish_pics";
            Info info;
            String dishId = request.getParameter("dishId");
            String dishPic = request.getParameter("dishPic");
            info=managerService.deleteDish(dishId,dishPic,realPath1);
            request.getSession().setAttribute("info",info);
            response.sendRedirect("/200web/dashboard");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应类型和编码
        request.getSession().setAttribute("activeBar",request.getParameter("activeBar"));
        response.setCharacterEncoding("UTF-8");
        System.out.println(request.getParameter("button"));
        if(request.getParameter("type").equals("modifyDish")){
            String originalPath = getServletContext().getRealPath("/");
            int targetIndex = originalPath.indexOf("target");
            String basePath = originalPath.substring(0, targetIndex);
            String realPath1 = basePath + "src\\main\\webapp\\data\\dish_pics";
            String realPath2 = basePath + "src\\main\\webapp\\data\\dish_picstmp";
            Canteen canteen = (Canteen) request.getSession().getAttribute("canteen");
            Info info;
            try {
                info = managerService.modifyDish(request,realPath1,realPath2,canteen);
            } catch (FileUploadException e) {
                throw new RuntimeException(e);
            }
            request.getSession().setAttribute("info",info);
            response.sendRedirect("/200web/dashboard");


        }
        else if(request.getParameter("type").equals("newDish")){//处理新增菜品请求
            String originalPath = getServletContext().getRealPath("/");
            int targetIndex = originalPath.indexOf("target");
            String basePath = originalPath.substring(0, targetIndex);
            String realPath1 = basePath + "src\\main\\webapp\\data\\dish_pics";
            String realPath2 = basePath + "src\\main\\webapp\\data\\dish_picstmp";
            Canteen canteen = (Canteen) request.getSession().getAttribute("canteen");
            Info info;
            try {
                info = managerService.newDish(request,realPath1,realPath2,canteen);
                System.out.println(info.getDescription());
            } catch (FileUploadException e) {
                throw new RuntimeException(e);
            }
            request.getSession().setAttribute("info",info);
            response.sendRedirect("/200web/dashboard");
        }
    }
}
