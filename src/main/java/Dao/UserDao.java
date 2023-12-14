package dao;

import java.util.ArrayList;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojo.User;

public interface UserDao {
    User login(User user) throws SQLException, ClassNotFoundException;
    boolean register(User user) throws SQLException, ClassNotFoundException;
    boolean modify(User user) throws SQLException, ClassNotFoundException;
    boolean isNameExist(String name) throws SQLException, ClassNotFoundException;
    boolean isNameExist(Integer id, String name) throws SQLException, ClassNotFoundException;
}


