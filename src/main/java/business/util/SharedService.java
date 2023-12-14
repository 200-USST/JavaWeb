package business.util;

import pojo.User;

public interface SharedService {
    public User login(String userName,String userPassword);
    public Boolean modifyPassword(String oldPsw,String newPsw);
}
