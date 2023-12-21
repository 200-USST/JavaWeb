package service.admin;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileUploadException;
import pojo.Canteen;
import pojo.Info;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface AdminService {
    public Info distributeCanteenAdmin(String userName, String userPsw, String userPswRe,String canteenName);//Root用户分发管理员账号
    public Info newCanteen(HttpServletRequest request,String realPath,String tmpPath) throws FileUploadException, IOException;//Root用户新增食堂
}
