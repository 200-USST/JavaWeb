package business.admin;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService{
    private UserDao userDao = new UserDaoImpl();
    @Override
    public String distributeCanteenAdmin(String userName,String userPsw,String userPswRe) {

    }
}
