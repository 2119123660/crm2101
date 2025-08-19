package star.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import star.pojo.Adopt;
import star.pojo.AdoptQuery;
import star.pojo.Pet;
import star.pojo.PetQuery;

import java.util.List;

@Mapper
public interface AdoptMapper {
    @Insert("insert into adopt(adopt_user_id,adopt_pet_id,adopt_date) values(#{adoptUserId},#{adoptPetId},#{adoptDate})")
    int addNewAdopt(Adopt adopt);
    List<Adopt> getAdoptListByParam(AdoptQuery adoptQuery);
}
