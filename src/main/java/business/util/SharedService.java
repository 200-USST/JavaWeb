package business.util;

import pojo.Canteen;
import pojo.Dish;
import pojo.Info;
import pojo.User;

import java.util.ArrayList;

public interface SharedService {
    public User login(String userName,String userPassword);
    public Info modifyPassword(User user, String oldPsw, String newPsw, String newPswRe);
    public Info modifyProfile(User user,String userName,String age,String gender);
    public void updateAllInfo(ArrayList<User> users, ArrayList<Canteen> canteens, ArrayList<Dish> dishes);
}
