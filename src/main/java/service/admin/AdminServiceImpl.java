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
import java.io.IOException;
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
    public Info newCanteen(HttpServletRequest request, String realPath, String tmpPath) throws FileUploadException, IOException {
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
        Canteen canteen  = new Canteen(null,canteenName,canteenLocation,canteenAbstract,null);
        if(canteenDao.isNameExist(canteenName)){ //判断食堂已经存在
            return new Info(false,"Canteen has already existed");
        }
        else {
            canteen = canteenDao.newCanteen(canteen);
            if(!uploadfiletype.equals("")){//存在图片
                canteen.setCanteenPic(canteen.getCanteenId()+"."+uploadfiletype);
                canteenDao.modify(canteen);
                for (FileItem fileItem : fileItems) {
                    if (!fileItem.isFormField()) {
                        FileUploadOnly.fileup(realPath,fileItem, String.valueOf(canteen.getCanteenId()));
                    }
                }
            }
            return new Info(true,"New Canteen successfully");
        }
    }

    @Override
    public Info modifyCanteen(HttpServletRequest request, String realPath, String tmpPath) throws FileUploadException, IOException {
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
        String canteenLocation = null;
        String canteenAbstract= null;
        String canteenId = null;
        String uploadfiletype = null;
        String canteenPic = null;
        for(FileItem item : fileItems){
            if (item.isFormField()) {
                String fieldName = item.getFieldName();
                String fieldValue = item.getString("UTF-8");
                switch (fieldName) {
                    case "canteenName":
                        canteenName = fieldValue;
                        break;
                    case "canteenLocation":
                        canteenLocation = fieldValue;
                        break;
                    case "canteenAbstract":
                        canteenAbstract = fieldValue;
                        break;
                    case "canteenId":
                        canteenId = fieldValue;
                        break;
                    case  "canteenPic":
                        canteenPic = fieldValue;
                        break;
                }
            }
            else {
                String uploadpath = item.getName();
                String uploadfilename = uploadpath.substring(uploadpath.lastIndexOf("/") + 1);
                uploadfiletype = uploadfilename.substring(uploadfilename.lastIndexOf(".") + 1);
            }
        }
        Canteen canteen = new Canteen(Integer.parseInt(canteenId),canteenName,canteenLocation,canteenAbstract,canteenPic);
        if(!uploadfiletype.equals("")){//修改了图片
            canteen.setCanteenPic(canteen.getCanteenId()+"."+uploadfiletype);
            canteenDao.modify(canteen);
            for (FileItem fileItem : fileItems) {
                if (!fileItem.isFormField()) {
                    FileUploadOnly.fileup(realPath,fileItem, String.valueOf(canteen.getCanteenId()));
                }
            }
        }
        else {//未修改图片
            canteenDao.modify(canteen);
        }
        return new Info(true,"Modify canteen successfully");
    }

    @Override
    public Info deleteCanteen(String canteenId, String canteenPic, String realPath) {
        canteenDao.deleteCanteen(canteenId);
        File directory = new File(realPath);
        // 确保该路径是目录
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    // 检查文件名是否是你要删除的文件
                    if (file.getName().equals(canteenPic)) {
                        file.delete();
                    }
                }
            }
        } else {
            System.out.println("目录不存在或不是一个目录");
        }
        return new Info(true,"Delete canteen successfully");
    }

    @Override
    public Info modifyProfile(User user) {
        userDao.modify(user);
        return new Info(true,"Modify profile successfully");
    }

    @Override
    public Info deleteUser(String userId) {
        userDao.deleteUser(userId);
        return new Info(true,"delete user successfully");
    }

}

