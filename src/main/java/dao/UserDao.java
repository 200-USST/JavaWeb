package dao;

import pojo.User;

import java.util.ArrayList;

public interface UserDao {
    User login(User user);
    void register(User user);
    void modify(User user);
    boolean isNameExist(String name);
    boolean isNameExist(Integer id, String name);
    void addManagerToCanteen(String managerName,String canteenName);//添加管理员和食堂的关系
    ArrayList<User> queryAllUsers();
}


