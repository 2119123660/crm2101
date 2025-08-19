package star.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import star.exception.GlobalException;
import star.pojo.PetType;
import star.pojo.PetTypeQuery;
import star.result.Result;
import star.service.PetTypeService;

@RestController
@RequestMapping("/petType")
@Api(tags="宠物类型相关API接口")
@CrossOrigin
public class PetTypeController {
    @Autowired
    private PetTypeService petTypeService;
    @ApiOperation("通过宠物类型id查询宠物类型")
    @GetMapping("/getPetTypeById/{petId}")
    public Result getPetTypeById(@PathVariable Integer petId){
        try {
            PetType petType = petTypeService.getPetTypeById(petId);
            return Result.ok(petType);
        } catch (GlobalException e) {
            return Result.build(e.getCode(),e.getMessage());
        }
    }
    @ApiOperation(("删除宠物类型"))
    @PostMapping("/deletePetType")
    public Result deletePetType(@RequestBody PetType petType){
        try {
            petTypeService.deletPetType(petType);
            return Result.ok();
        } catch (GlobalException e) {
            return Result.build(e.getCode(),e.getMessage());
        }
    }

    @ApiOperation("添加新类型")
    @PostMapping("/addNewPetType")
    public Result addNewPetType(@RequestBody PetType petType){
        try {
            petTypeService.addNewPetType(petType);
            return Result.ok();
        } catch (GlobalException e) {
            return Result.build(e.getCode(),e.getMessage());
        }
    }

    @ApiOperation("分页查询宠物类型")
    @PostMapping("/getPetTypeByParam")
    public Result getPetTypeByParam(@RequestBody PetTypeQuery petTypeQuery){
        PageInfo pageInfo=petTypeService.getPetTypeListByParam(petTypeQuery);
        return Result.ok(pageInfo);
    }

    @ApiOperation("获取宠物类型")
    @GetMapping("/getPetType")
    public Result getPetType(){
        return Result.ok(petTypeService.getPetTypeList());
    }
}
