package star.service;

import com.github.pagehelper.PageInfo;
import star.pojo.Admin;
import star.pojo.User;
import star.pojo.UserQuery;

public interface AdminService {
    //添加新用户
    void addNewUser(User user);
    //分页查询所有用户
    PageInfo getUserByParam(UserQuery userQuery);
    Admin adminLogin(Admin admin);
}
