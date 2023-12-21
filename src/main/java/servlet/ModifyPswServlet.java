package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.util.Rc;
import service.util.SharedService;
import service.util.SharedServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.Info;
import pojo.User;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "modifyPsw", value = "/modifyPsw")
public class ModifyPswServlet extends HttpServlet {
    SharedService sharedService =new SharedServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String oldPsw = "szp123123";
        String newPsw = "szp1231234";
        String newPswRepeat = "szp1231234";
        Info info=sharedService.modifyPassword(user,oldPsw,newPsw,newPswRepeat);
        request.getSession().setAttribute("info",info);
        response.sendRedirect("/200web/dashboard");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("type").equals("newDish")){
            ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
            try {
                List<FileItem> items = upload.parseRequest(new Rc(request));
            } catch (FileUploadException e) {
                throw new RuntimeException(e);
            }
        }else {
            User user = (User) request.getSession().getAttribute("user");
            String oldPsw = request.getParameter("oldPsw");
            String newPsw = request.getParameter("newPsw");
            String newPswRepeat = request.getParameter("newPswRepeat");
            Info info=sharedService.modifyPassword(user,oldPsw,newPsw,newPswRepeat);
            request.getSession().setAttribute("user",user);
            request.getSession().setAttribute("info",info);
            request.getSession().setAttribute("activeBar",request.getParameter("activeBar"));
            response.sendRedirect("/200web/dashboard");
        }

    }
}
