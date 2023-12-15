package business.util;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.Info;
import pojo.User;


public class SharedServiceImpl implements SharedService{
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(String userName, String userPassword) {
        User user =new User(null, userName,userPassword, null, null, null);
        user=userDao.login(user);
        return user;
    }

    @Override
    public Info modifyPassword(User user, String oldPsw, String newPsw, String newPswRe) {
        if(!user.getUserPassword().equals(oldPsw)){
            return new Info(false,"修改失败,旧密码输入错误！");
        }
        else if(!newPsw.equals(newPswRe)){
            return new Info(false,"修改失败,两次新密码输入不一致！");
        }
        return new Info(true,"修改成功");
    }
}
