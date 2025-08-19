package star.service;

import com.github.pagehelper.PageInfo;
import star.pojo.Admin;
import star.pojo.User;
import star.pojo.UserQuery;

public interface UserService {

    //根据手机号更新用户信息
    void updataUserByTel(User user);
    //根据用户手机号查询用户信息
    User getUserBtTel(String tel);
    //用户登录
    User userLogin(User user);

    //注册
    void register(String tel, String pwd);
}
