package star.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import star.pojo.Pet;
import star.pojo.PetQuery;
import star.pojo.PetType;
import star.result.Result;
import star.service.PetService;
import star.service.PetTypeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pet")
@Api(tags="宠物相关API接口")
@CrossOrigin
public class PetController {
    @Autowired
    private PetService petService;
    @Autowired
    private PetTypeService petTypeService;
    @ApiOperation("根据宠物ID查询宠物信息接口")
    @GetMapping("/getPetById/{petId}")
    public Result getPetById(@PathVariable Integer petId){
        Pet pet = petService.getPetById(petId);
        return Result.ok(pet);
    }

    @ApiOperation("修改宠物信息接口")
    @PostMapping("/updatePet")
    public Result updatePet(@RequestBody Pet pet){
        petService.updatePet(pet);
        return Result.ok();
    }
    @ApiOperation("删除宠物")
    @GetMapping("/deletePetById/{petId}")
    public Result deletePetById(@PathVariable Integer petId){
        petService.deletePetById(petId);
        return Result.ok();
    }
    @ApiOperation("新增宠物")
    @PostMapping("/addNewPet")
    public Result addNewPet(@RequestBody Pet pet){
        petService.addNewPet(pet);
        return Result.ok();
    }

    @ApiOperation("分页查询宠物接口")
    @PostMapping("/getPetListByParam")
    public Result getPetListByParam(@RequestBody PetQuery petQuery){
        PageInfo pageInfo=petService.getPetListByParam(petQuery);
        List<PetType> petTypeList = petTypeService.getPetTypeList();
        Map<String,Object> map=new HashMap<>();
        map.put("pageInfo",pageInfo);
        map.put("petTypeList",petTypeList);
        return Result.ok(map);
    }
}
