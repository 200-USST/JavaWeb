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
import java.util.HashMap;
import java.util.List;
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
    public void updateAllInfo(ArrayList<User> users, ArrayList<Canteen> canteens, StringBuilder id_canteen, Map<String, Canteen> manager_canteen_pair, StringBuilder canteen_manager_json, Map<String, List<Dish>> canteen_dishes_dict, StringBuilder canteen_dishes_json) {
        ObjectMapper mapper = new ObjectMapper();

        users.addAll(userDao.queryAllUsers());
        canteens.addAll(canteenDao.queryAllCanteens());

        try {
            id_canteen.append(mapper.writeValueAsString(canteenDao.getAllCanteenWithID()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        manager_canteen_pair.putAll(userDao.getAllManagersWithCanteen());
        try {
            ObjectMapper mapper = new ObjectMapper();
            canteen_manager_json.append(mapper.writeValueAsString(canteenDao.getAllCanteenWithManager()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        canteen_dishes_dict.putAll(canteenDao.getAllCanteenWithDishes());

        Map<String, List<String>> cdJson = new HashMap<>();
        for (var entry : canteen_dishes_dict.entrySet()) {
            List<String> dishes = new ArrayList<>();
            for (var d : entry.getValue()) {
                dishes.add(d.getDishName());
            }
            cdJson.put(entry.getKey(), dishes);
        }
        try {
            canteen_dishes_json.append(mapper.writeValueAsString(cdJson));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
