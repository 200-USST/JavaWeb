package service.canteenAdmin;

import pojo.Canteen;
import pojo.Dish;
import pojo.Info;
import pojo.User;

public interface ManagerService {
    public Info modifyCanteen(Canteen canteen);
    public Canteen findCanteen(User user);

    public Info newDish(Dish dish);
}
