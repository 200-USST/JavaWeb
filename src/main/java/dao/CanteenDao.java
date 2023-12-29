package dao;

import pojo.Canteen;
import pojo.Dish;
import pojo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface CanteenDao {
    Canteen newCanteen(Canteen canteen);//创建新食堂，将新食堂信息填入到食堂数据库
    String findCanteenName(User user);//根据管理者找到他所管理的食堂的名字
    Canteen findCanteen(String manager);
    boolean isNameExist(String canteenName);
    void modify(Canteen canteen);
    ArrayList<Canteen> queryAllCanteens();
    Map<String, List<String>> getAllCanteenWithManager ();
    Map<String, List<Dish>> getAllCanteenWithDishes ();
    public void deleteCanteen(String canteenId);
    void managerModifyCanteen(String canteenId,String canteenAbstract);
    Integer findCanteenId(String canteenName);

    public Map<Integer, String> getAllCanteenWithID();
}
