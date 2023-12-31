package service.util;

import pojo.Canteen;
import pojo.Dish;
import pojo.Info;
import pojo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface SharedService {
    public User login(String userName,String userPassword);
    public Info modifyPassword(User user, String oldPsw, String newPsw, String newPswRe);
    public Info modifyProfile(User user,String userName,String age,String gender);
    public void updateAllInfo(ArrayList<User> users, ArrayList<Canteen> canteens, StringBuilder id_canteen, Map<String, Canteen> manager_canteen_pair, StringBuilder canteen_manager_json, Map<String, List<Dish>> canteen_dishes_dict, StringBuilder canteen_dishes_json);
}
