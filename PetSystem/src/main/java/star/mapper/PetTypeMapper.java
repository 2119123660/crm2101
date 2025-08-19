package star.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Select;
import star.pojo.PetType;
import star.pojo.PetTypeQuery;

import java.util.List;

@Mapper
public interface PetTypeMapper {
    @Select("select * from pet_type where type_id=#{typeId}")
    PetType getPetTypeById(Integer typeId);
    @Delete("delete from pet_type WHERE type_Id = #{typeId}")
    int deletePetTypeById(int typeId);
    @Select("select count(type_id) from pet_type where type_name=#{typeName}")
    int getPetTypeByName(String typeName);
    @Insert("insert into pet_type(type_name) values (#{typeName})")
    int addNewPetType(PetType petType);
    @Select("select * from pet_type")
    List<PetType> getPetTypeByParam(PetTypeQuery petTypeQuery);
    @Select("select * from pet_type")
    List<PetType> getPetType();
}
