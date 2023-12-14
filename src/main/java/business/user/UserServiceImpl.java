package business.user;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;

public class UserServiceImpl implements UserService{
    UserDao userDao=new UserDaoImpl();
    @Override
    public String register(String userName, String userPsw, String userPswRe) {

        return null;
    }
}
