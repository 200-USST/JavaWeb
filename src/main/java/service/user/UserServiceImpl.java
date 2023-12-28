package service.user;

import dao.CanteenDao;
import dao.DishDao;
import dao.impl.CanteenDaoImpl;
import dao.impl.DishDaoImpl;
import pojo.Dish;
import service.util.Validator;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.Info;
import pojo.User;

import java.util.ArrayList;


public class UserServiceImpl implements UserService{
    UserDao userDao=new UserDaoImpl();
    DishDao dishDao = new DishDaoImpl();
    CanteenDao canteenDao = new CanteenDaoImpl();
    @Override
    public Info register(String userName, String userPsw, String userPswRe) {
        if(userDao.isNameExist(userName)){
            return new Info(false,"The username already exists");
        }
        else if(!Validator.isValidUsername(userName).getFlag()) return Validator.isValidUsername(userName);
        else {
            if(!userPsw.equals(userPswRe)){
                return new Info(false,"The two password inputs are inconsistent");
            }
            else if(!Validator.isValidPassword(userPsw).getFlag()){
                return Validator.isValidPassword(userPsw);
            }
            else {
                userDao.register(new User(null,userName,userPsw,"user",null,null));
                return new Info(true,"Register Successfully");
            }
        }
    }

    @Override
    public void queryDishesByorder(String order, String value, ArrayList<Dish> dishes) {
        for(var t : dishes){
            System.out.println(t.getDishName());
        }
        if(value.equals("")){//说明按类别排序
            if(order.equals("")){
                dishes.addAll(dishDao.queryAllDishes());
                System.out.println(1);
            }
            else {
                switch (order){
                    case "菜系": {
                        dishes.addAll(dishDao.queryDishByClass());
                        System.out.println(2);
                        break;
                    }
                    case "价格": {
                        dishes.addAll(dishDao.queryDishesByPrice());
                        System.out.println(3);
                        break;
                    }
                    case "食堂": {
                        dishes.addAll(dishDao.queryDishesByCanteen());
                        System.out.println(4);
                        break;
                    }
                }
            }

        }
        else {
                switch (order){
                    case "菜系": {
                        dishes.addAll(dishDao.queryDishByClass(value));
                        System.out.println(5);
                        break;
                    }
                    case "价格": {
                        dishes.addAll(dishDao.queryDishesByPrice(value));
                        System.out.println(6);
                        break;
                    }
                    case "食堂": {
                        dishes.addAll(dishDao.queryDishByCanteen(canteenDao.findCanteenId(value)));
                        System.out.println(7);
                        break;
                    }
                }
        }

    }
}
