package dao.impl;

import dao.UserDao;
import pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private Connection connection = null;
    final static String HOST = "10.100.164.43";
    final static String DB_NAME = "JavaWeb";
    final static String USER_NAME = "root";
    final static String PASSWORD = "123456";

    private void initConn() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + DB_NAME, USER_NAME, PASSWORD);
        }
    }
    @Override
    public User login(User user) throws SQLException, ClassNotFoundException {
        initConn();
        var name = user.getUserName();
        var pass = user.getUserPassword();

        var sql = "select * from user where userName = ? and userPassword = ?";
        var statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, pass);
        var result = statement.executeQuery();

        if (result.next()) {
            return new User(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6)
            );
        } else {
            return null;
        }
    }

    public boolean register(User user) throws SQLException, ClassNotFoundException {
        initConn();
        var name = user.getUserName();

        var sql = "select * from user where userName = ?";
        var statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        var result = statement.executeQuery();
        if (result.next()) return false;

        var sql1 = "insert into user (userName, userPassword, userIdentity, userGender, userAge) values (?, ?, ?, ?, ?)";
        var statement1 = connection.prepareStatement(sql1);
        statement1.setString(1, user.getUserName());
        statement1.setString(2, user.getUserPassword());
        statement1.setString(3, user.getUserIdentity());
        statement1.setString(4, user.getUserGender());
        statement1.setString(5, user.getUserAge());
        statement1.executeUpdate();

        return true;
    }
}