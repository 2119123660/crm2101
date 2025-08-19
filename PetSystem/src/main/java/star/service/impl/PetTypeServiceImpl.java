package star.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import star.exception.GlobalException;
import star.mapper.PetTypeMapper;
import star.pojo.PetType;
import star.pojo.PetTypeQuery;
import star.result.ResultCodeEnum;
import star.service.PetTypeService;

import java.util.List;

@Service
public class PetTypeServiceImpl implements PetTypeService {

    @Autowired
    private PetTypeMapper petTypeMapper;


    @Override
    public PetType getPetTypeById(Integer typeId) {
        PetType petType = petTypeMapper.getPetTypeById(typeId);
        if(petType!=null){
            return petType;
        }else{
            throw new GlobalException(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public void deletPetType(PetType petType) {
        int count = petTypeMapper.getPetTypeByName(petType.getTypeName());
        if(count>=0){
            petTypeMapper.deletePetTypeById(petType.getTypeId());
        }else{
            throw new GlobalException(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public void addNewPetType(PetType petType) {
        int count = petTypeMapper.getPetTypeByName(petType.getTypeName());
        if(count>0){
            throw new GlobalException(ResultCodeEnum.FAIL);
        }else{
            petTypeMapper.addNewPetType(petType);
        }
    }

    @Override
    public PageInfo getPetTypeListByParam(PetTypeQuery petTypeQuery) {
        PageHelper.startPage(petTypeQuery.getPage(),5);
        List<PetType> petTypeList=petTypeMapper.getPetTypeByParam(petTypeQuery);
        PageInfo pageInfo=new PageInfo(petTypeList);
        return pageInfo;
    }

    @Override
    public List<PetType> getPetTypeList() {
        return petTypeMapper.getPetType();
    }
}
