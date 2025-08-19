package star.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import star.exception.GlobalException;
import star.mapper.AdoptMapper;
import star.mapper.PetMapper;
import star.mapper.UserMapper;
import star.pojo.Adopt;
import star.pojo.AdoptQuery;
import star.pojo.Pet;
import star.result.ResultCodeEnum;
import star.service.AdoptService;

import java.util.List;

@Service
public class AdoptServiceImpl implements AdoptService {
    @Autowired
    private AdoptMapper adoptMapper;
    @Autowired
    private PetMapper petMapper;
    @Override
    public Adopt addNewAdopt(Adopt adopt) {
        Pet pet = petMapper.getPetById(adopt.getAdoptPetId());
        if(pet.getPetDescr().equals("已领养")){
            throw new GlobalException(ResultCodeEnum.FAIL);
        }else{
            petMapper.updatePetDescr(adopt.getAdoptPetId(),"已领养");
            adoptMapper.addNewAdopt(adopt);
            return adopt;
        }
    }

    @Override
    public PageInfo getAdoptListByParam(AdoptQuery adoptQuery) {
        PageHelper.startPage(adoptQuery.getPage(),5);
        List<Adopt> adoptList=adoptMapper.getAdoptListByParam(adoptQuery);
        PageInfo pageInfo=new PageInfo(adoptList);
        return pageInfo;
    }
}
