package business.util;

import pojo.Info;
import pojo.User;

public interface SharedService {
    public User login(String userName,String userPassword);
    public Info modifyPassword(User user, String oldPsw, String newPsw, String newPswRe);

}
