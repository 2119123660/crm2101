package star.service;

import com.github.pagehelper.PageInfo;
import star.pojo.Pet;
import star.pojo.PetQuery;

public interface PetService {
    //根据ID查询宠物信息
    Pet getPetById(Integer petId);
    //修改宠物
    void updatePet(Pet pet);
    //删除宠物
    void deletePetById(Integer petId);
    //添加心宠物
    void addNewPet(Pet pet);
    //分页查询宠物列表
    PageInfo getPetListByParam(PetQuery petQuery);
}
