package dao;


import dao.impl.UserDaoImpl;
import pojo.*;

import java.sql.SQLException;

public class TestConn {

    private static UserDao userDao;

    public TestConn() {

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        var user = new User(null, "admin", "123456", "root", "male", "18");

        userDao = new UserDaoImpl();
        var us = userDao.login(user);
        if(us != null) {
            System.out.println("success");
            System.out.println(us.getId());
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
