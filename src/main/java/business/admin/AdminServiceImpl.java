package business.admin;

import business.util.Validator;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.Info;
import pojo.User;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService{
    private UserDao userDao = new UserDaoImpl();

    @Override
    public Info distributeCanteenAdmin(String userName, String userPsw, String userPswRe,String canteenName) {
        try {
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
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
