package dao;


import pojo.Dish;

import java.util.ArrayList;

public interface DishDao {
    public ArrayList<Dish> queryAllDishes();//查询所有菜品列表
    public Dish newDish(Dish dish);//新建菜品
    public boolean isNameExist(String dishName,String canteenName);//查询菜品名字是否已经存在
    public void modifyDish(Dish dish);
}
