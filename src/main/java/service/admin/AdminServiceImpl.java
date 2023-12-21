package service.admin;

import service.util.Validator;
import dao.CanteenDao;
import dao.UserDao;
import dao.impl.CanteenDaoImpl;
import dao.impl.UserDaoImpl;
import pojo.Canteen;
import pojo.Info;
import pojo.User;


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
    public Info newCanteen(String canteenName,String canteenLocation,String canteenAbstract){
        if(canteenDao.isNameExist(canteenName)){
            return new Info(false,"The canteen name already exists");
        }
        else if(!Validator.isValidCanteenName(canteenName).getFlag()) return Validator.isValidCanteenName(canteenName);
        else {
            canteenDao.newCanteen(new Canteen(null,canteenName,canteenLocation,canteenAbstract));
            return new Info(true,"Found canteen successfully");
        }

    }
}
