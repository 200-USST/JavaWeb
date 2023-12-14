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
    public Boolean modifyPassword(String oldPsw, String newPsw) {
        return null;
    }
}
