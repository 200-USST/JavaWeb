package business.admin;

import pojo.Info;
import pojo.User;

public interface AdminService {
    public Info distributeCanteenAdmin(String userName, String userPsw, String userPswRe,String canteenName);
    public Info newCanteen(String canteenName,String canteenLocation,String canteenAbstract);
}
