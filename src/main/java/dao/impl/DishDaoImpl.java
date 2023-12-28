package dao.impl;

import dao.DishDao;
import dao.util.DatabaseHelper;
import pojo.Canteen;
import pojo.Dish;
import pojo.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DishDaoImpl implements DishDao {
    private final DatabaseHelper DbHelper = new DatabaseHelper();
    @Override
    public ArrayList<Dish> queryAllDishes() {
        var result = DbHelper.query(
                "select * from dish"
        );
        return (ArrayList<Dish>) makeResultList(result);
    }

    @Override
    public Dish newDish(Dish dish) {
        DbHelper.update(
                "insert into dish (dishesName, dishesCuisine, dishesAbstract, dishesCanteen, dishesPrice, dishPic) values (?, ?, ?, ?, ?, ?)",
                dish.getDishName(), dish.getDishClass(), dish.getDishInfo(), dish.getDishCanteenId(), dish.getDishPrice(), dish.getDishPic()
        );

        var result = DbHelper.query(
                "select * from dish where dishesName = ? and dishesCanteen = ?",
                dish.getDishName(), dish.getDishCanteenId()
        );

        return new Dish(
                (Integer) result.get(0).get(0),
                (String) result.get(0).get(1),
                (String) result.get(0).get(2),
                ((BigDecimal) result.get(0).get(5)).doubleValue(),
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

    @Override
    public List<Dish> getAllDishesSoldIn(Canteen canteen) {
        var result = DbHelper.query(
                "select * from dish where dishesCanteen = ?",
                canteen.getCanteenId()
        );

        return makeResultList(result);
    }

    @Override
    public void deleteDish(String dishId) {
        DbHelper.update(
                "delete from dish where dishesID = ?",
                dishId
        );
    }

    @Override
    public ArrayList<Dish> queryDishesByCanteen() {
        var result = DbHelper.query(
                "select * from dish order by dishesCanteen"
        );
        return (ArrayList<Dish>) makeResultList(result);
    }

    @Override
    public ArrayList<Dish> queryDishesByPrice() {
        var result = DbHelper.query(
                "select * from dish order by dishesPrice"
        );
        for(var i : (ArrayList<Dish>) makeResultList(result)){
            System.out.println(i.getDishName());
        }
        return (ArrayList<Dish>) makeResultList(result);
    }

    @Override
    public ArrayList<Dish> queryDishByClass() {
        var result = DbHelper.query(
                "select * from dish order by dishesCuisine"
        );
        return (ArrayList<Dish>) makeResultList(result);
    }

    @Override
    public ArrayList<Dish> queryDishByCanteen(String canteenId) {
        var result = DbHelper.query(
                "select * from dish where dishesCanteen = ?",
                canteenId
        );
        return (ArrayList<Dish>) makeResultList(result);
    }

    @Override
    public ArrayList<Dish> queryDishesByPrice(String dishPrice) {
        var result = DbHelper.query(
                "select * from dish where dishesPrice = ?",
                Double.parseDouble(dishPrice)
        );
        return (ArrayList<Dish>) makeResultList(result);
    }

    @Override
    public ArrayList<Dish> queryDishByClass(String dishClass) {
        var result = DbHelper.query(
                "select * from dish where dishesCuisine = ?",
                dishClass
        );
        return (ArrayList<Dish>) makeResultList(result);
    }

    private List<Dish> makeResultList(List<List<Object>> result) {
        List<Dish> list = new ArrayList<>();
        for (var row : result) {
            list.add(new Dish(
                    (Integer) row.get(0),
                    (String) row.get(1),
                    (String) row.get(2),
                    ((BigDecimal) row.get(5)).doubleValue(),
                    (String) row.get(3),
                    (Integer) row.get(4),
                    (String) row.get(6)
            ));
        }
        return list;
    }
}
