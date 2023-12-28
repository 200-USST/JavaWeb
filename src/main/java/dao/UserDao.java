package dao;

import pojo.Canteen;
import pojo.User;

import java.util.ArrayList;
import java.util.Map;

public interface UserDao {
    User login(User user);
    void register(User user);
    void modify(User user);
    boolean isNameExist(String name);
    boolean isNameExist(Integer id, String name);
    void addManagerToCanteen(String managerName,String canteenName);//添加管理员和食堂的关系
    ArrayList<User> queryAllUsers();
    Map<String, Canteen> getAllManagersWithCanteen();
    void deleteUser(String userId);//删除某个用户
}


