package business.user;

import pojo.Info;

public interface UserService {
    public Info register(String userName, String userPsw, String userPswRe);
}
