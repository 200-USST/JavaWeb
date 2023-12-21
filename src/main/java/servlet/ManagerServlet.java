package servlet;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.canteenAdmin.ManagerService;
import service.canteenAdmin.ManagerServiceImpl;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.Canteen;
import pojo.Info;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "manager", value = "/manager")
public class ManagerServlet extends HttpServlet {
    ManagerService managerService =new ManagerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应类型和编码
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        if(request.getParameter("type").equals("modifyCanteen")){//处理修改食堂信息请求
            String canteenAbstract = request.getParameter("canteenAbstract");
            Canteen canteen= (Canteen) request.getSession().getAttribute("canteen");
            canteen.setCanteenAbstract(canteenAbstract);
            Info info=managerService.modifyCanteen(canteen);
            request.getSession().setAttribute("canteen",canteen);
            request.getSession().setAttribute("info",info);
            request.getSession().setAttribute("activeBar",request.getParameter("activeBar"));
            response.sendRedirect("/200web/dashboard");
        }
        else if(request.getParameter("type").equals("newDish")){//处理新增菜品请求
            String originalPath = getServletContext().getRealPath("/");
            int targetIndex = originalPath.indexOf("target");
            String basePath = originalPath.substring(0, targetIndex);
            String realPath1 = basePath + "src\\main\\webapp\\data\\dish_pics";
            String realPath2 = basePath + "src\\main\\webapp\\data\\dish_picstmp";
//          Canteen canteen = (Canteen) request.getSession().getAttribute("canteen");
            Info info;
            Canteen canteen = new Canteen(1,"思餐厅","南校","好吃");
            try {
                info = managerService.newDish(request,realPath1,realPath2,canteen);
                System.out.println(info.getDescription());
            } catch (FileUploadException e) {
                throw new RuntimeException(e);
            }
            request.getSession().setAttribute("info",info);
            request.getSession().setAttribute("activeBar",request.getParameter("activeBar"));
            response.sendRedirect("/200web/dashboard");
        }
    }
}
