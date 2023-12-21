package service.admin;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import pojo.Dish;
import service.util.FileUploadOnly;
import service.util.Rc;
import service.util.Validator;
import dao.CanteenDao;
import dao.UserDao;
import dao.impl.CanteenDaoImpl;
import dao.impl.UserDaoImpl;
import pojo.Canteen;
import pojo.Info;
import pojo.User;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;


public class AdminServiceImpl implements AdminService{
    private UserDao userDao = new UserDaoImpl();
    private CanteenDao canteenDao =new CanteenDaoImpl();

    @Override
    public Info distributeCanteenAdmin(String userName, String userPsw, String userPswRe,String canteenName) {
        if(userDao.isNameExist(userName)){
            return new Info(false,"The username already exists");
        }
        else if(!Validator.isValidUsername(userName).getFlag()) return Validator.isValidUsername(userName);
        else {
            if(!userPsw.equals(userPswRe)){
                return new Info(false,"The two password inputs are inconsistent");
            }
            else if(!Validator.isValidPassword(userPsw).getFlag()){
                return Validator.isValidPassword(userPsw);
            }
            else {
                userDao.register(new User(null,userName,userPsw,"manager",null,null));
                userDao.addManagerToCanteen(userName,canteenName);
                return new Info(true,"Register Successfully");
            }
        }
    }

    @Override
    public Info newCanteen(HttpServletRequest request, String realPath, String tmpPath) throws FileUploadException, UnsupportedEncodingException {
        File saveFilePath = new File(realPath);
        File tempFilePath = new File(tmpPath);
        if (!saveFilePath.exists()) {
            saveFilePath.mkdir();
        }
        if (!tempFilePath.exists()) {
            tempFilePath.mkdir();
        }

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setSizeThreshold(1024 * 1024);
        diskFileItemFactory.setRepository(tempFilePath);

        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setHeaderEncoding("utf-8");
        servletFileUpload.setFileSizeMax(1024 * 1024 * 10);

        List<FileItem> fileItems = servletFileUpload.parseRequest(new Rc(request));
        String canteenName = null;
        String canteenAbstract = null;
        String canteenLocation= null;
        String uploadfiletype = null;
        for(FileItem item : fileItems){
            if (item.isFormField()) {
                String fieldName = item.getFieldName();
                String fieldValue = item.getString("UTF-8");

                switch (fieldName) {
                    case "canteenName":
                        canteenName = fieldValue;
                        break;
                    case "canteenAbstract":
                        canteenAbstract = fieldValue;
                        break;
                    case "canteenLocation":
                        canteenLocation = fieldValue;
                        break;
                }
            }
            else {
                String uploadpath = item.getName();
                String uploadfilename = uploadpath.substring(uploadpath.lastIndexOf("/") + 1);
                uploadfiletype = uploadfilename.substring(uploadfilename.lastIndexOf(".") + 1);
            }
        }
        Canteen canteen  = new Canteen(null,canteenName,canteenLocation,canteenAbstract);
        if(canteenDao.isNameExist(canteenName)){ //判断该食堂存在该菜品
            return new Info(false,"Canteen has already existed");
        }
        else {
//            dish.setDishPic(dish.getDishId()+"."+uploadfiletype);
//            dishDao.modifyDish(dish);
//            for (FileItem fileItem : fileItems) {
//                if (!fileItem.isFormField()) {
//                    if(fileItem.getSize()>0) FileUploadOnly.fileup(realPath,fileItem, String.valueOf(dish.getDishId()));
//                    else System.out.println(12);
//                }
//            }
//            return new Info(true,"New dish successfully");
        }
        return null;
    }
    }

