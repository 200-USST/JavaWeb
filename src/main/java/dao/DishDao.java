package dao;


import pojo.Dish;

import java.util.ArrayList;

public interface DishDao {
    public ArrayList<Dish> queryAllDishes();//查询所有菜品列表
    public void newDish(Dish dish);//新建菜品
    public boolean isNameExist(String dishName);//查询菜品名字是否已经存在
}
