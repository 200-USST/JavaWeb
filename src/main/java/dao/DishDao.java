package dao;


import pojo.Canteen;
import pojo.Dish;

import java.util.ArrayList;
import java.util.List;

public interface DishDao {
    public ArrayList<Dish> queryAllDishes();//查询所有菜品列表
    public Dish newDish(Dish dish);//新建菜品
    public boolean isNameExist(String dishName,Integer canteenId);//查询菜品名字是否已经存在
    public void modifyDish(Dish dish);
    List<Dish> getAllDishesSoldIn(Canteen canteen);
    public void deleteDish(String dishId);//根据菜品的ID删除该菜品

    public ArrayList<Dish> queryDishesByCanteen();
    public ArrayList<Dish> queryDishesByPrice();
    public ArrayList<Dish> queryDishByClass();
    public ArrayList<Dish> queryDishByCanteen(Integer canteenId);
    public ArrayList<Dish> queryDishesByPrice(String dishPrice);
    public ArrayList<Dish> queryDishByClass(String dishClass);
}
