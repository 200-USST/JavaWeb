package dao.impl;

import dao.CanteenDao;
import dao.DishDao;
import pojo.Canteen;
import pojo.Dish;
import pojo.User;
import dao.util.DatabaseHelper;

import java.util.*;

public class CanteenDaoImpl implements CanteenDao {
    private final DatabaseHelper DbHelper = new DatabaseHelper();
    @Override
    public Canteen newCanteen(Canteen canteen) {
        DbHelper.update(
                "insert into canteen (canteenName, canteenLocation, canteenAbstract, canteenPic) values (?, ?, ?, ?)",
                canteen.getCanteenName(), canteen.getCanteenLocation(), canteen.getCanteenAbstract(), canteen.getCanteenPic()
        );

        var result = DbHelper.query(
                "select * from canteen where canteenName = ?",
                canteen.getCanteenName()
        );

        return new Canteen(
                (Integer) result.get(0).get(0), (String) result.get(0).get(1), (String) result.get(0).get(2), (String) result.get(0).get(3), (String) result.get(0).get(4)
        );
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
    public Canteen findCanteen(String manager) {
        var canteen_name = (String) DbHelper.query(
                "select canteenName from canteen_manager where managerName = ?",
                manager
        ).get(0).get(0);

        var result = DbHelper.query(
                "select * from canteen where canteenName = ?",
                canteen_name
        );

        return new Canteen(
                (Integer) result.get(0).get(0), (String) result.get(0).get(1), (String) result.get(0).get(2), (String) result.get(0).get(3),(String) result.get(0).get(4)
        );
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
        var origin_name = DbHelper.query(
                "select canteenName from canteen where canteenID = ?",
                canteen.getCanteenId()
        ).get(0).get(0);

        DbHelper.update(
                "update canteen set canteenName = ?, canteenLocation = ?, canteenAbstract = ?, canteenPic = ? where canteenID = ?",
                canteen.getCanteenName(),
                canteen.getCanteenLocation(),
                canteen.getCanteenAbstract(),
                canteen.getCanteenPic(),
                canteen.getCanteenId()
        );
        DbHelper.update(
                "update canteen_manager set canteenName = ? where canteenName = ?",
                canteen.getCanteenName(),
                origin_name
        );
    }

    @Override
    public ArrayList<Canteen> queryAllCanteens() {//返回所有食堂信息列表
        var result = DbHelper.query(
                "select * from canteen"
        );
        ArrayList<Canteen> canteens =new ArrayList<>();
        for (var can : result) {
            canteens.add(new Canteen(
                    (Integer) can.get(0), (String) can.get(1), (String) can.get(2), (String) can.get(3),(String) can.get(4)
            ));
        }
        return canteens;
    }

    public Map<String, List<String>> getAllCanteenWithManager () {
        var all_canteen = DbHelper.query(
                "select canteenName from canteen"
        );
        Map<String, List<String>> map = new HashMap<>();
        for (var canteen : all_canteen) {
            var all_manager = DbHelper.query(
                    "select managerName from canteen_manager where canteenName = ?",
                    canteen.get(0)
            );
            List<String> manager_list = new ArrayList<>();
            for (var manager : all_manager) {
                manager_list.add((String) manager.get(0));
            }
            map.put((String) canteen.get(0), manager_list);
        }
        return map;
    }

    @Override
    public Map<String, List<Dish>> getAllCanteenWithDishes() {
        DishDao dishDao = new DishDaoImpl();

        var all_canteen = queryAllCanteens();
        Map<String, List<Dish>> map = new HashMap<>();
        for (var canteen : all_canteen) {
            var dishes_sold_in_canteen = dishDao.getAllDishesSoldIn(canteen);
            map.put(canteen.getCanteenName(), dishes_sold_in_canteen);
        }

        return map;
    }

    @Override
    public void deleteCanteen(String canteenId) {

    }
}
