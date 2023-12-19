package dao.impl;

import dao.UserDao;
import pojo.User;
import dao.util.DatabaseHelper;

import java.util.ArrayList;

public class UserDaoImpl implements UserDao {
    private final DatabaseHelper DbHelper = new DatabaseHelper();
    @Override
    public User login(User user) {
        var result = DbHelper.query(
                "select * from user where binary userName = ? and binary userPassword = ?",
                user.getUserName(),
                user.getUserPassword()
        );

        if (!result.isEmpty()) {
            return new User(
                    (Integer) result.get(0).get(0),
                    (String) result.get(0).get(1),
                    (String) result.get(0).get(2),
                    (String) result.get(0).get(3),
                    (String) result.get(0).get(4),
                    (String) result.get(0).get(5)
            );
        } else {
            return null;
        }
    }

    public void register(User user) {
        DbHelper.update(
                "insert into user (userName, userPassword, userIdentity, userGender, userAge) values (?, ?, ?, ?, ?)",
                user.getUserName(),
                user.getUserPassword(),
                user.getUserIdentity(),
                user.getUserGender(),
                user.getUserAge()
        );
    }

    public void modify(User user) {
        DbHelper.update(
                "update user set userName = ?, userPassword = ?, userIdentity = ?, userGender = ?, userAge = ? where userID = ?",
                user.getUserName(),
                user.getUserPassword(),
                user.getUserIdentity(),
                user.getUserGender(),
                user.getUserAge(),
                user.getId()
        );
    }

    public boolean isNameExist(String name) {
        var result = DbHelper.query(
                "select * from user where binary userName = ?",
                name
        );

        return !result.isEmpty();

    }
    public boolean isNameExist(Integer id, String name) {
        var result = DbHelper.query(
                "select * from user where binary userName = ? and userID != ?",
                name, id
        );

        return !result.isEmpty();
    }

    @Override
    public void addManagerToCanteen(String managerName, String canteenName) {
        DbHelper.update(
                "insert into canteen_manager (canteenName, managerName) values (?, ?)",
                canteenName, managerName
        );
    }

    @Override
    public ArrayList<User> queryAllUsers() {
        var result = DbHelper.query(
                "select * from user"
        );
        ArrayList<User> users =new ArrayList<>();
        for (var user : result) {
            users.add(new User(
                    (Integer) user.get(0), (String) user.get(1), (String) user.get(2), (String) user.get(3), (String) user.get(4), (String) user.get(5)
            ));
        }
        return users;
    }
}