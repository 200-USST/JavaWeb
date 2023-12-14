package dao;

import java.util.ArrayList;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojo.User;

public interface UserDao {
    boolean login(User user) throws SQLException, ClassNotFoundException;
    boolean register(User user) throws SQLException, ClassNotFoundException;
}


