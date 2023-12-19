package dao;


import pojo.Dish;

import java.util.ArrayList;

public interface DishDao {
    public ArrayList<Dish> queryAllDishes();
}
