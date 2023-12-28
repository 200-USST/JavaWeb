package service.admin;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileUploadException;
import pojo.Info;

import java.io.IOException;


public interface AdminService {
    public Info distributeCanteenAdmin(String userName, String userPsw, String userPswRe,String canteenName);//Root用户分发管理员账号
    public Info newCanteen(HttpServletRequest request,String realPath,String tmpPath) throws FileUploadException, IOException;//Root用户新增食堂
    public Info modifyCanteen(HttpServletRequest request, String realPath, String tmpPath) throws FileUploadException, IOException;
    public Info deleteCanteen(String canteenId,String canteenPic, String realPath);
}
