package star.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import star.exception.GlobalException;
import star.mapper.AdminMapper;
import star.mapper.UserMapper;
import star.pojo.Admin;
import star.pojo.User;
import star.pojo.UserQuery;
import star.result.ResultCodeEnum;
import star.service.AdminService;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public void addNewUser(User user) {
        User user1 = userMapper.getuserByTel(user.getUserTel());
        if(user1==null){
            adminMapper.addNewUser(user);
        }else{
            throw new GlobalException(ResultCodeEnum.REGISTER_MOBLE_ERROR);
        }
    }

    @Override
    public PageInfo getUserByParam(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getPage(),5);
        List<User> userList=adminMapper.getUserByParam(userQuery);
        PageInfo pageInfo=new PageInfo(userList);
        return pageInfo;
    }

    @Override
    public Admin adminLogin(Admin admin) {
        //根据管理员账号查询
        Admin admin1=adminMapper.getAdminByName(admin.getAdminName());
        if(admin1==null){
            throw new GlobalException(ResultCodeEnum.LOGIN_ACL);
        }else{
            if(admin1.getAdminPwd().equals(admin.getAdminPwd())){
                return admin1;
            }else{
                throw new GlobalException(ResultCodeEnum.LOGIN_PWD_ERROR);
            }
        }
    }
}
