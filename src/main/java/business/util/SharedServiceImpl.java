package business.util;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;

import java.sql.SQLException;

public class SharedServiceImpl implements SharedService{
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(String userName, String userPassword) {
        User user =new User(null, userName,userPassword, null, null, null);
        try {
            user=userDao.login(user);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public String modifyPassword(User user, String oldPsw, String newPsw, String newPswRe) {
        if(!user.getUserPassword().equals(oldPsw)){
            return "修改失败,旧密码输入错误！";
        }
        else if(!newPsw.equals(newPswRe)){
            return "修改失败,两次新密码输入不一致！";
        }
        return "";
    }
}
