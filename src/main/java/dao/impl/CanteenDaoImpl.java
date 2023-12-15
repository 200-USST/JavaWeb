package dao.impl;

import dao.CanteenDao;
import pojo.Canteen;
import pojo.User;
import util.DatabaseHelper;

public class CanteenDaoImpl implements CanteenDao {
    private final DatabaseHelper DbHelper = new DatabaseHelper();
    @Override
    public Canteen newCanteen(Canteen canteen) {
        DbHelper.update(
                "insert into canteen (canteenName, canteenLocation, canteenAbstract) values (?, ?, ?)",
                canteen.getCanteenName(), canteen.getCanteenLocation(), canteen.getCanteenAbstract()
        );
        return null;
    }

    @Override
    public String findCanteenName(User user) {
        var result = DbHelper.query(
                "select canteenName from canteen_manager where managerName = ?",
                user.getUserName()
        );
        if (!result.isEmpty()) {
            return (String) result.get(0).get(0);
        }
        return null;
    }

    @Override
    public boolean isNameExist(String canteenName) {
        var result = DbHelper.query(
                "select * from canteen where binary canteenName = ?",
                canteenName
        );

        return !result.isEmpty();
    }
}
