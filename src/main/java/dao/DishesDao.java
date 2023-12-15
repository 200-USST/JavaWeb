package dao;

import pojo.Canteen;
import pojo.Dish;

import java.sql.SQLException;
import java.util.List;

public interface DishesDao {
    List<Dish> selectCanteen(Integer canteenID) throws SQLException, ClassNotFoundException;
}
