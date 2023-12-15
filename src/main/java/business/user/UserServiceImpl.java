package business.user;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;

import java.sql.SQLException;

public class UserServiceImpl implements UserService{
    UserDao userDao=new UserDaoImpl();
    @Override
    public String register(String userName, String userPsw, String userPswRe) {
        try {
            if(userDao.isNameExist(userName)){
                return "1用户命已存在";
            }
            else {
                if(!userPsw.equals(userPswRe)){
                    return "2两次密码输入不一致";
                }
                else {
                    userDao.register(new User(null,userName,userPsw,null,null,null));
                    return "3注册成功";
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
