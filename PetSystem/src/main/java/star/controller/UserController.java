package star.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import star.exception.GlobalException;
import star.pojo.Admin;
import star.pojo.User;
import star.result.Result;
import star.service.UserService;

@RestController
@RequestMapping("/user")
@Api(tags="用户相关API接口")
@CrossOrigin
public class UserController {


    @Autowired
    private UserService userService;

    @ApiOperation("更新用户信息接口")
    @PostMapping("/updataUserByTel")
    public Result updataUserByTel(@RequestBody User user){
        System.out.println("user="+user);
        try {
            userService.updataUserByTel(user);
            return Result.ok();
        } catch (GlobalException e) {
            return Result.build(e.getCode(),e.getMessage());
        }
    }
    @ApiOperation("用户信息展示接口")
    @GetMapping("/getUserByTel/{tel}")
    public Result etUserBtTel(@PathVariable String tel){
        User user = userService.getUserBtTel(tel);
        return Result.ok(user);
    }
    @ApiOperation("用户注册接口")
    @RequestMapping("/userRegister/{tel}/{pwd}")
    public Result userRegister(@PathVariable String tel, @PathVariable String pwd){
        System.out.println("tel="+tel);
        System.out.println("pwd="+pwd);
        //判断手机号是否可用
        //调用业务层注册方法
        try {
            userService.register(tel,pwd);
        }catch (GlobalException e){
            return Result.build(e.getCode(),e.getMessage());
        }
        return Result.build(200,"注册成功");
    }

    @ApiOperation("用户登录接口")
    @RequestMapping("/userLogin")
    public Result userLogin(@RequestBody User user){
        System.out.println("user="+user);
        try {
            User user1 = userService.userLogin(user);
            return Result.ok(user1);
        } catch (GlobalException e) {
            return Result.build(e.getCode(),e.getMessage());
        }

    }

}
