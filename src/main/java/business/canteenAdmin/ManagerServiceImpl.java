package business.canteenAdmin;

import dao.CanteenDao;
import dao.impl.CanteenDaoImpl;
import pojo.Canteen;
import pojo.Info;
import pojo.User;

public class ManagerServiceImpl implements ManagerService{
    CanteenDao canteenDao =new CanteenDaoImpl();
    @Override
    public Info modifyCanteen(Canteen canteen) {
        canteenDao.modify(canteen);
        return new Info(true,"Modify canteen successfully");
    }

    @Override
    public Canteen findCanteen(User user) {
        return canteenDao.findCanteen(user);
    }
}
