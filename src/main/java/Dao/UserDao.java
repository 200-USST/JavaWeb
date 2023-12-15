package dao;

import java.util.ArrayList;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojo.User;

public interface UserDao {
    User login(User user) throws SQLException, ClassNotFoundException;
    void register(User user) throws SQLException, ClassNotFoundException;
    void modify(User user) throws SQLException, ClassNotFoundException;
    boolean isNameExist(String name) throws SQLException, ClassNotFoundException;
    boolean isNameExist(Integer id, String name) throws SQLException, ClassNotFoundException;
    void addManagerToCanteen(String managerName,String canteenName);//添加管理员和食堂的关系
}


