package service.canteenAdmin;

import dao.CanteenDao;
import dao.DishDao;
import dao.impl.CanteenDaoImpl;
import dao.impl.DishDaoImpl;
import pojo.Canteen;
import pojo.Dish;
import pojo.Info;
import pojo.User;

public class ManagerServiceImpl implements ManagerService{
    CanteenDao canteenDao =new CanteenDaoImpl();
    DishDao dishDao = new DishDaoImpl();
    @Override
    public Info modifyCanteen(Canteen canteen) {
        canteenDao.modify(canteen);
        return new Info(true,"Modify canteen successfully");
    }

    @Override
    public Canteen findCanteen(User user) {
        return canteenDao.findCanteen(user.getUserName());
    }

    @Override
    public Info newDish(Dish dish) {
        if(dishDao.isNameExist(dish.getDishName())){
            return new Info(false,"Dish has exists");
        }
       else {
           dishDao.newDish(dish);
           return new Info(true,"New dish successfully");
        }
    }
}
