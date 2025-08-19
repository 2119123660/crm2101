package star.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import star.exception.GlobalException;
import star.pojo.Adopt;
import star.pojo.AdoptQuery;
import star.result.Result;
import star.service.AdoptService;

@RestController
@RequestMapping("/adopt")
@Api(tags="领养相关API接口")
@CrossOrigin
public class AdoptController {
    @Autowired
    private AdoptService adoptService;
    //新增领养信息
    @ApiOperation("新增领养信息")
    @PostMapping("/addNewAdopt")
    public Result addNewAdopt(@RequestBody Adopt adopt){
        try {
            Adopt adopt1 = adoptService.addNewAdopt(adopt);
            return Result.ok(adopt1);
        } catch (GlobalException e) {
            return Result.build(e.getCode(),e.getMessage());
        }
    }
    @ApiOperation("分页查询领养信息")
    @PostMapping("/getAdoptListByParam")
    public Result getAdoptListByParam(@RequestBody AdoptQuery adoptQuery){
        PageInfo page = adoptService.getAdoptListByParam(adoptQuery);
        return Result.ok(page);
    }
}
