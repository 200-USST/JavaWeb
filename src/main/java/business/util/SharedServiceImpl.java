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
            return Validator.isValidPassword(newPsw);
        }
        else  {
            user.setUserPassword(newPsw);
            userDao.modify(user);
            return new Info(true,"Modify successfully");
        }
    }

    @Override
    public Info modifyProfile(User user,String userName,String age,String gender) {
        if(!Validator.isValidUsername(userName).getFlag()){
            return Validator.isValidUsername(userName);
        }
        else{
            user.setUserName(userName);
            user.setUserAge(age);
            user.setUserGender(gender);
            userDao.modify(user);
            return new Info(true,"Modify successfully");
        }
    }
}
