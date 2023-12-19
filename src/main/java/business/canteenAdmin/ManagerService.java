package business.canteenAdmin;

import pojo.Canteen;
import pojo.Info;
import pojo.User;

public interface ManagerService {
    public Info modifyCanteen(Canteen canteen);
    public Canteen findCanteen(User user);
}
