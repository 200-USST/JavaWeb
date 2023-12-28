package service.user;

import pojo.Dish;
import pojo.Info;

import java.util.ArrayList;

public interface UserService {
    public Info register(String userName, String userPsw, String userPswRe);
    public void queryDishesByorder(String order, String value, ArrayList<Dish> dishes);
}
