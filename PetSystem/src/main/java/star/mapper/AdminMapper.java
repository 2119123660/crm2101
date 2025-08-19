package star.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import star.pojo.Admin;
import star.pojo.User;
import star.pojo.UserQuery;

import java.util.List;
@Mapper
public interface AdminMapper {
    //添加新顾客
    @Insert("insert into user(user_name,user_tel,user_email,user_age,user_sex,user_weichat)"+
            "values (#{userName},#{userTel},#{userEmail},#{userAge},#{userSex},#{userWeiChat})")
    int addNewUser(User user);
    //分页查询所以用户
    List<User> getUserByParam(UserQuery userQuery);
    //管理员登录账号

    /**
     * 根据管路员账号查询管理员信息
     * @param adminName
     * @return
     */
    @Select("select * from admin where admin_name=#{adminName}")
    Admin getAdminByName(@Param("adminName") String adminName);
}
