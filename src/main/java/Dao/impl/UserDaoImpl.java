package dao.impl;

import dao.UserDao;
import jakarta.persistence.criteria.CriteriaBuilder;
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

        var sql = "select * from user where binary userName = ? and binary userPassword = ?";
        var statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, pass);
        var result = statement.executeQuery();

        if (result.next()) {
            return new User(
                    result.getInt(1),
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
    // 改了吗

    public boolean register(User user) throws SQLException, ClassNotFoundException {
        if (isNameExist(user.getUserName())) return false;

        initConn();

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

    public boolean modify(User user) throws SQLException, ClassNotFoundException {
        if (isNameExist(user.getId(), user.getUserName())) return false;

        initConn();

        var sql = "update user set userName = ?, userPassword = ?, userIdentity = ?, userGender = ?, userAge = ? where userID = ?";
        var statement = connection.prepareStatement(sql);
        statement.setString(1, user.getUserName());
        statement.setString(2, user.getUserPassword());
        statement.setString(3, user.getUserIdentity());
        statement.setString(4, user.getUserGender());
        statement.setString(5, user.getUserAge());
        statement.setInt(6, user.getId());
        statement.executeUpdate();

        return true;
    }

    private boolean isNameExist(String name) throws SQLException, ClassNotFoundException {
        initConn();

        String sql;
        sql = "select * from user where binary userName = ?";
        var statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        var result = statement.executeQuery();

        return result.next();

    }
    private boolean isNameExist(Integer id, String name) throws SQLException, ClassNotFoundException {
        initConn();

        var sql = "select * from user where binary userName = ? and userID != ?";
        var statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setInt(2, id);
        var result = statement.executeQuery();

        return result.next();
    }
}