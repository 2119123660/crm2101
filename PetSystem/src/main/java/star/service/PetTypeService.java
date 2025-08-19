package star.service;


import com.github.pagehelper.PageInfo;
import star.pojo.PetQuery;
import star.pojo.PetType;
import star.pojo.PetTypeQuery;

import java.util.List;

public interface PetTypeService {
    //根据id查询宠物类型
    PetType getPetTypeById(Integer typeId);
    //删除宠物类型
    void deletPetType(PetType petType);
    //新增类型
    void addNewPetType(PetType petType);
    //分页查询宠物类型列表
    PageInfo getPetTypeListByParam(PetTypeQuery petTypeQuery);
    public List<PetType> getPetTypeList();
}
