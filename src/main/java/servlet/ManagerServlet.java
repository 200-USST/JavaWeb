package servlet;

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
        if(request.getAttribute("type").equals("modifyCanteen")){
            String canteenAbstract = request.getParameter("canteenAbstract");
            Canteen canteen= (Canteen) request.getSession().getAttribute("canteen");
            canteen.setCanteenAbstract(canteenAbstract);
            Info info=managerService.modifyCanteen(canteen);
            request.getSession().setAttribute("canteen",canteen);
            Gson gson = new Gson();
            String infoJson = gson.toJson(info);
            PrintWriter out = response.getWriter();
            out.print(infoJson);
            out.flush();
        }
        else if(request.getParameter("type").equals("newDish")){
            if(!ServletFileUpload.isMultipartContent((RequestContext) request)){
                System.out.println(123);
            };
        }
    }
}
