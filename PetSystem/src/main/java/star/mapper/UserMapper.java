package star.mapper;

import org.apache.ibatis.annotations.*;
import star.pojo.Admin;
import star.pojo.User;

@Mapper
public interface UserMapper {

    //修改用户信息
    @Update("update user set user_name=#{userName},user_headpt=#{userHeadpt},user_email=#{userEmail},"+
            "user_age=#{userAge},user_sex=#{userSex},user_weichat=#{userWeiChat} where user_tel=#{userTel}")
    int updataUserByTel(User user);
    //注册新用户
    @Insert("insert into user(user_tel,user_pwd) values (#{tel},#{pwd})")
    int register(@Param("tel") String tel,@Param("pwd") String pwd);
    //判断手机号是否被注册
    @Select("select count(user_id)  from user where user_tel=#{tel}")
    int checkTel(@Param("tel") String tel);

    //通过手机号查询用户
    @Select("select * from user where user_Tel=#{userTel}")
    User getuserByTel(@Param("userTel") String userTel);
}
