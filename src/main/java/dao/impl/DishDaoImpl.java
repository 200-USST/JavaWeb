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
                    (Integer) dish.get(0), (String) dish.get(1), (String) dish.get(2), (Double) dish.get(3), (String) dish.get(4), (Integer) dish.get(5),(String) dish.get(6)
            ));
        }
        return dishes;
    }

    @Override
    public Dish newDish(Dish dish) {
        DbHelper.update(
                "insert into dish (dishesName, dishesCuisine, dishesAbstract, dishesCanteen, dishesPrice, dishPic) values (?, ?, ?, ?, ?, ?)",
                dish.getDishName(), dish.getDishClass(), dish.getDishInfo(), dish.getDishCanteenId(), dish.getDishPrice(), dish.getDishPic()
        );

        var result = DbHelper.query(
                "select * from dish where dishesID = last_insert_id()"
        );

        return new Dish(
                (Integer) result.get(0).get(0),
                (String) result.get(0).get(1),
                (String) result.get(0).get(2),
                (Double) result.get(0).get(5),
                (String) result.get(0).get(3),
                (Integer) result.get(0).get(4),
                (String) result.get(0).get(6)
        );
    }

    @Override
    public boolean isNameExist(String dishName,Integer canteenId) {
         var result = DbHelper.query(
                 "select * from dish where binary dishesName = ? and dishesCanteen = ?",
                 dishName, canteenId
         );

         return !result.isEmpty();
    }

    @Override
    public void modifyDish(Dish dish) {
        DbHelper.update(
                "update dish set dishesName = ?, dishesCuisine = ?, dishesAbstract = ?, dishesPrice = ?, dishPic = ? where dishesID = ?",
                dish.getDishName(), dish.getDishClass(), dish.getDishInfo(), dish.getDishPrice(), dish.getDishPic(), dish.getDishId()
        );
    }
}
