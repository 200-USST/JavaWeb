package dao;


import dao.impl.UserDaoImpl;
import pojo.*;

import java.sql.SQLException;

public class TestConn {

    private static UserDao userDao;

    public TestConn() {

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        var user = new User(null, "rlagofla", "12345", "student", "male", "18");

        userDao = new UserDaoImpl();
        if(userDao.login(user)) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }

        if(userDao.register(user)) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }

    }



}
