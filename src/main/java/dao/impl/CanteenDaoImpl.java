package dao.impl;

import dao.CanteenDao;
import pojo.Canteen;
import pojo.User;
import dao.util.DatabaseHelper;

import java.util.ArrayList;

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
    public Canteen findCanteen(User user) {
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

    @Override
    public void modify(Canteen canteen) {

    }

    @Override
    public ArrayList<Canteen> queryAllCanteens() {//返回所有食堂信息列表
        var result = DbHelper.query(
                "select * from canteen"
        );
        ArrayList<Canteen> canteens =new ArrayList<>();
        for (var can : result) {
            canteens.add(new Canteen(
                    (Integer) can.get(0), (String) can.get(1), (String) can.get(2), (String) can.get(3)
            ));
        }
        return canteens;
    }
}
