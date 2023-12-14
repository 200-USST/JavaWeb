package dao;


import dao.impl.UserDaoImpl;
import pojo.*;

import java.sql.SQLException;

public class TestConn {

    private static UserDao userDao;

    public TestConn() {

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        var user = new User("1", "rlagofla", "123456", "student", "male", "18");

        userDao = new UserDaoImpl();
        var us = userDao.login(user);
        if(us != null) {
            System.out.println("success");
            System.out.println(us.getId());
        } else {
            System.out.println("fail");
        }

        var bol = userDao.modify(user);
        if (bol) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }



    }



}
