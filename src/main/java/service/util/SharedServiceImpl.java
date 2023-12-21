package service.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CanteenDao;
import dao.DishDao;
import dao.UserDao;
import dao.impl.CanteenDaoImpl;
import dao.impl.DishDaoImpl;
import dao.impl.UserDaoImpl;
import pojo.Canteen;
import pojo.Dish;
import pojo.Info;
import pojo.User;

import java.util.ArrayList;
import java.util.Map;


public class SharedServiceImpl implements SharedService{
    private UserDao userDao = new UserDaoImpl();
    private CanteenDao canteenDao = new CanteenDaoImpl();
    private DishDao dishDao =new DishDaoImpl();
    @Override
    public User login(String userName, String userPassword) {
        User user =new User(null, userName,userPassword, null, null, null);
        user=userDao.login(user);
        return user;
    }

    @Override
    public Info modifyPassword(User user, String oldPsw, String newPsw, String newPswRe) {
        if(!user.getUserPassword().equals(oldPsw)){
            return new Info(false,"Failed to modify, old password entered wrong");
        }
        else if(!newPsw.equals(newPswRe)){
            return new Info(false,"Failed to modify, two new password input is inconsistent!");
        }
        else if(!Validator.isValidPassword(newPsw).getFlag()){
            return Validator.isValidPassword(newPsw);
        }
        else  {
            user.setUserPassword(newPsw);
            userDao.modify(user);
            return new Info(true,"Modify successfully");
        }
    }

    @Override
    public Info modifyProfile(User user,String userName,String age,String gender) {
        if(!Validator.isValidUsername(userName).getFlag()){
            return Validator.isValidUsername(userName);
        }
        else{
            user.setUserName(userName);
            user.setUserAge(age);
            user.setUserGender(gender);
            userDao.modify(user);
            return new Info(true,"Modify successfully");
        }
    }

    @Override
    public void updateAllInfo(ArrayList<User> users, ArrayList<Canteen> canteens, ArrayList<Dish> dishes, Map<String, Canteen> manager_canteen_pair, StringBuilder canteen_manager_json) {
        users.addAll(userDao.queryAllUsers());
        canteens.addAll(canteenDao.queryAllCanteens());
        dishes.addAll(dishDao.queryAllDishes());
        manager_canteen_pair.putAll(userDao.getAllManagersWithCanteen());

        try {
            ObjectMapper mapper = new ObjectMapper();
            canteen_manager_json.append(mapper.writeValueAsString(canteenDao.getAllCanteenWithManager()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
