package star.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import star.exception.GlobalException;
import star.pojo.Admin;
import star.pojo.User;
import star.pojo.UserQuery;
import star.result.Result;
import star.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Api(tags="管理员相关API接口")
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService adminService;



    @ApiOperation("添加新顾客")
    @PostMapping("/addNewUser")
    public Result addNewUser(@RequestBody User user){
        try {
            adminService.addNewUser(user);
            return Result.ok();
        } catch (GlobalException e) {
            return Result.build(e.getCode(),e.getMessage());
        }

    }
    @ApiOperation("分页查询所有用户")
    @PostMapping("/getUserByParam")
    public Result getUserByParam(@RequestBody UserQuery userQuery){
        PageInfo pageInfo=adminService.getUserByParam(userQuery);
        return Result.ok(pageInfo);
    }

    @ApiOperation("管理员登录接口")
    @RequestMapping("/adminLogin")
    public Result adminLogin(@RequestBody Admin admin){
        System.out.println("admin="+admin);
        Admin admin1 = null;
        try {
            admin1 = adminService.adminLogin(admin);
            return Result.ok(admin1);
        } catch (GlobalException e) {
            return Result.build(e.getCode(),e.getMessage());
        }

    }
}
