package star.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import star.exception.GlobalException;
import star.mapper.UserMapper;
import star.pojo.User;
import star.pojo.UserQuery;
import star.result.Result;
import star.result.ResultCodeEnum;
import star.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;



    @Override
    public void updataUserByTel(User user) {
        //验证要修改的记录是否存在
        User user1 = userMapper.getuserByTel(user.getUserTel());
        if (user1!=null){
            userMapper.updataUserByTel(user);
        }else{
            throw new GlobalException(ResultCodeEnum.LOGIN_Tel_ERROR);
        }

    }

    @Override
    public User getUserBtTel(String tel) {
        User user = userMapper.getuserByTel(tel);
        return user;
    }

    @Override
    public User userLogin(User user) {
        User user1= userMapper.getuserByTel(user.getUserTel());
        if(user1==null){
            throw new GlobalException(ResultCodeEnum.LOGIN_Tel_ERROR);
        }else{
            if(user1.getUserPwd().equals(user.getUserPwd())){
                return user1;
            }else{
                throw new GlobalException(ResultCodeEnum.LOGIN_PWD_ERROR);
            }
        }
    }

    @Override
    public void register(String tel, String pwd) {
        int count = userMapper.checkTel(tel);
        if(count>0){
            throw new GlobalException(ResultCodeEnum.REGISTER_MOBLE_ERROR);
        }else{
            userMapper.register(tel,pwd);
        }
    }
}
