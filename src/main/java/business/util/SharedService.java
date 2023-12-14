package business.util;

import pojo.User;

public interface SharedService {
    public User login(String userName,String userPassword);
    public String modifyPassword(User user,String oldPsw,String newPsw,String newPswRe);
}
