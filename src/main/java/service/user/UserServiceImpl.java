package service.user;

import service.util.Validator;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.Info;
import pojo.User;


public class UserServiceImpl implements UserService{
    UserDao userDao=new UserDaoImpl();
    @Override
    public Info register(String userName, String userPsw, String userPswRe) {
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
                userDao.register(new User(null,userName,userPsw,"user",null,null));
                return new Info(true,"Register Successfully");
            }
        }
    }
}
