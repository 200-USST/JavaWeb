package service.canteenAdmin;

import dao.CanteenDao;
import dao.DishDao;
import dao.impl.CanteenDaoImpl;
import dao.impl.DishDaoImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import pojo.Canteen;
import pojo.Dish;
import pojo.Info;
import pojo.User;
import service.util.FileUploadOnly;
import service.util.Rc;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class ManagerServiceImpl implements ManagerService{
    CanteenDao canteenDao =new CanteenDaoImpl();
    DishDao dishDao = new DishDaoImpl();
    @Override
    public Info modifyCanteen(Canteen canteen) {
        canteenDao.modify(canteen);
        return new Info(true,"Modify canteen successfully");
    }

    @Override
    public Canteen findCanteen(User user) {
        return canteenDao.findCanteen(user.getUserName());
    }

    @Override
    public Info newDish(HttpServletRequest request, String realPath, String tmpPath,Canteen canteen) throws FileUploadException, IOException {
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
        String dishName = null;
        double dishPrice = 0;
        String dishClass = null;
        String dishInfo= null;
        String uploadfiletype = null;
        for(FileItem item : fileItems){
            if (item.isFormField()) {
                String fieldName = item.getFieldName();
                String fieldValue = item.getString("UTF-8");

                switch (fieldName) {
                    case "dishName":
                        dishName = fieldValue;
                        break;
                    case "dishPrice":
                        dishPrice = Double.parseDouble(fieldValue);
                        break;
                    case "dishClass":
                        dishClass = fieldValue;
                        break;
                    case "dishInfo":
                        dishInfo = fieldValue;
                        break;
                }
            }
            else {
                String uploadpath = item.getName();
                String uploadfilename = uploadpath.substring(uploadpath.lastIndexOf("/") + 1);
                uploadfiletype = uploadfilename.substring(uploadfilename.lastIndexOf(".") + 1);
            }
        }
        Dish dish =new Dish(null,dishName,dishClass,dishPrice,dishInfo,canteen.getCanteenId(),null);
        if(dishDao.isNameExist(dishName,canteen.getCanteenId())){//判断该食堂存在该菜品
            return new Info(false,"Dish has already existed");
        }
        else {
            dish= dishDao.newDish(dish);
            dish.setDishPic(dish.getDishId()+"."+uploadfiletype);
            dishDao.modifyDish(dish);
            for (FileItem fileItem : fileItems) {
                if (!fileItem.isFormField()) {
                    if(fileItem.getSize()>0) FileUploadOnly.fileup(realPath,fileItem, String.valueOf(dish.getDishId()));
                    else System.out.println(12);
                }
            }
            return new Info(true,"New dish successfully");
        }
    }

    @Override
    public Info modifyDish(HttpServletRequest request, String realPath, String tmpPath, Canteen canteen) throws FileUploadException, IOException {
        File saveFilePath = new File(realPath);
        File tempFilePath = new File(tmpPath);
        boolean flag = false;
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
        String dishName = null;
        double dishPrice = 0;
        String dishClass = null;
        String dishInfo= null;
        String uploadfiletype = null;
        String dishId = null;//会传回dish Id
        String dishPic = null;
        for(FileItem item : fileItems){
            if (item.isFormField()) {
                String fieldName = item.getFieldName();
                String fieldValue = item.getString("UTF-8");
                switch (fieldName) {
                    case "dishName":
                        dishName = fieldValue;
                        break;
                    case "dishPrice":
                        dishPrice = Double.parseDouble(fieldValue);
                        break;
                    case "dishClass":
                        dishClass = fieldValue;
                        break;
                    case "dishInfo":
                        dishInfo = fieldValue;
                        break;
                    case "dishId" :
                        dishId= fieldValue;
                        break;
                    case "dishPic" :
                        dishPic= fieldValue;
                        break;
                }
            }
            else {
                System.out.println(1);
                flag = true;
                String uploadpath = item.getName();
                String uploadfilename = uploadpath.substring(uploadpath.lastIndexOf("/") + 1);
                uploadfiletype = uploadfilename.substring(uploadfilename.lastIndexOf(".") + 1);

            }
        }
        if(dishDao.isNameExist(dishName,canteen.getCanteenId())){//判断该食堂存在该菜品
            return new Info(false,"Dishname has already existed");
        }
        else {
            Dish dish =new Dish(Integer.parseInt(dishId),dishName,dishClass,dishPrice,dishInfo,canteen.getCanteenId(),dishPic);
            if(flag){//修改了图片
                dish.setDishPic(dish.getDishId()+"."+uploadfiletype);
                dishDao.modifyDish(dish);
                for (FileItem fileItem : fileItems) {
                    if (!fileItem.isFormField()) {
                        if(fileItem.getSize()>0) FileUploadOnly.fileup(realPath,fileItem, String.valueOf(dish.getDishId()));
                        else System.out.println(12);
                    }
                }
            }
            else {//未修改图片
                dishDao.modifyDish(dish);
            }
            return new Info(true,"Modify dish successfully");
        }
    }
}
