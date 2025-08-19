package star.mapper;

import org.apache.ibatis.annotations.*;
import star.pojo.Pet;
import star.pojo.PetQuery;

import java.util.List;
@Mapper
public interface PetMapper {
    //更新宠物领养状态
    @Update("update pet set pet_descr=#{petDescr} where pet_id=#{petId}")
    int updatePetDescr(@Param("petId") Integer id,@Param("petDescr") String desccr);
    //根据宠物id查询宠物信息
    @Select("select * from pet where pet_id=#{petId}")
    Pet getPetById(Integer petId);
    //修改宠物信息
    @Update("update pet set pet_img=#{petImg},pet_breed=#{petBreed},pet_color=#{petColor},"+
            "pet_gender=#{petGender},pet_age=#{petAge},pet_weight=#{petWeight},"+
            "pet_descr=#{petDescr} where pet_id=#{petId}")
    int updataPet(Pet pet);
    //删除宠物
    @Delete("delete from pet where pet_id=#{petId}" )
    int deletePetById(Integer petId);
    //添加新宠物
    @Insert("insert into pet(pet_img,pet_type_id,pet_breed,pet_color,"+
            "pet_gender,pet_weight,pet_age,pet_descr) values (#{petImg},"+
            "#{petTypeId},#{petBreed},#{petColor}, #{petGender},#{petWeight},"+
            "#{petAge},#{petDescr})")
    int addNewPet(Pet pet);
    //分页查询宠物
    List<Pet> getPetByParam(PetQuery petQuery);
}
