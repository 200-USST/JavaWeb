package business.admin;

import pojo.Info;
import pojo.User;

public interface AdminService {
    public Info distributeCanteenAdmin(String userName, String userPsw, String userPswRe,String canteenName);//Root用户分发管理员账号
    public Info newCanteen(String canteenName,String canteenLocation,String canteenAbstract);//Root用户新增食堂
}
