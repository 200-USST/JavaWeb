package dao;

import pojo.Canteen;

import java.sql.SQLException;
import java.util.List;

public interface CanteenDao {
    List<Canteen> getAll() throws SQLException, ClassNotFoundException;

}
