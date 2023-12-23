package service.canteenAdmin;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileUploadException;
import pojo.Canteen;
import pojo.Dish;
import pojo.Info;
import pojo.User;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface ManagerService {
    public Info modifyCanteen(Canteen canteen);
    public Canteen findCanteen(User user);
    public Info newDish(HttpServletRequest request, String realPath, String tmpPath,Canteen canteen) throws FileUploadException, IOException;
    public Info modifyDish(HttpServletRequest request, String realPath, String tmpPath,Canteen canteen) throws FileUploadException, IOException;
    public Info deleteDish(String dishId,String dishPic, String realPath);
}
