package dao.impl;

import dao.DishDao;
import dao.util.DatabaseHelper;
import pojo.Dish;
import pojo.User;

import java.util.ArrayList;

public class DishDaoImpl implements DishDao {
    private final DatabaseHelper DbHelper = new DatabaseHelper();
    @Override
    public ArrayList<Dish> queryAllDishes() {
        var result = DbHelper.query(
                "select * from dish"
        );
        ArrayList<Dish> dishes =new ArrayList<>();
        for (var dish : result) {
            dishes.add(new Dish(
                    (Integer) dish.get(0), (String) dish.get(1), (String) dish.get(2), (Double) dish.get(3), (String) dish.get(4), (String) dish.get(5)
            ));
        }
        return dishes;
    }
}
