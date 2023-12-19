package business.util;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.Info;
import pojo.User;


public class SharedServiceImpl implements SharedService{
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(String userName, String userPassword) {
        User user =new User(null, userName,userPassword, null, null, null);
        user=userDao.login(user);
        return user;
    }

    @Override
    public Info modifyPassword(User user, String oldPsw, String newPsw, String newPswRe) {
        if(!user.getUserPassword().equals(oldPsw)){
            return new Info(false,"Failed to modify, old password entered wrong");
        }
        else if(!newPsw.equals(newPswRe)){
            return new Info(false,"Failed to modify, two new password input is inconsistent!");
        }
        else if(!Validator.isValidPassword(newPsw).getFlag()){
            return new Info(false,"Failed to modify, the new password does not meet specifications");
        }
        else  {
            user.setUserPassword(newPsw);
            userDao.modify(user);
            return new Info(true,"Modify successfully");
        }
    }
}
