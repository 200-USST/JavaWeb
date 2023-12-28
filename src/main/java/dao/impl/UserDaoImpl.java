package dao.impl;

import dao.CanteenDao;
import dao.UserDao;
import pojo.Canteen;
import pojo.User;
import dao.util.DatabaseHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
        if (user.getUserIdentity().equals("manager")) {
            var origin_name = DbHelper.query(
                    "select userName from user where userID = ?",
                    user.getId()
            ).get(0).get(0);

            DbHelper.update(
                    "update canteen_manager set managerName = ? where managerName = ?",
                    user.getUserName(),
                    origin_name
            );
        }

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

    public Map<String, Canteen> getAllManagersWithCanteen() {
        var result = DbHelper.query(
                "select * from canteen_manager"
        );

        CanteenDao canteenDao = new CanteenDaoImpl();
        Map<String, Canteen> pair = new HashMap<>();
        for (var row : result) {
            var manager = (String) row.get(1);
            var canteen = canteenDao.findCanteen(manager);
            pair.put(manager, canteen);
        }
        return pair;
    }

    @Override
    public void deleteUser(String userId) {

    }
}