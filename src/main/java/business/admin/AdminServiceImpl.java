package business.admin;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;

public class AdminServiceImpl implements AdminService{
    private UserDao userDao = new UserDaoImpl();
    @Override
    public String distributeCanteenAdmin(User user) {

    }
}