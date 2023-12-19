package dao;

import pojo.Canteen;
import pojo.User;

import java.util.ArrayList;

public interface CanteenDao {
    Canteen newCanteen(Canteen canteen);//创建新食堂，将新食堂信息填入到食堂数据库
    String findCanteenName(User user);//根据管理者找到他所管理的食堂的名字
    Canteen findCanteen(User user);
    boolean isNameExist(String canteenName);
    void modify(Canteen canteen);
    ArrayList<Canteen> queryAllCanteens();
}
