package star.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import star.mapper.PetMapper;
import star.pojo.Pet;
import star.pojo.PetQuery;
import star.service.PetService;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetMapper petMapper;

    @Override
    public Pet getPetById(Integer petId) {
        Pet pet = petMapper.getPetById(petId);
        return pet;
    }

    @Override
    public void updatePet(Pet pet) {
        System.out.println("pet="+pet);
        petMapper.updataPet(pet);
    }

    @Override
    public void deletePetById(Integer petId) {
        petMapper.deletePetById(petId);
    }

    @Override
    public void addNewPet(Pet pet) {
        petMapper.addNewPet(pet);
    }

    @Override
    public PageInfo getPetListByParam(PetQuery petQuery) {
        PageHelper.startPage(petQuery.getPage(),5);
        List<Pet> petList = petMapper.getPetByParam(petQuery);
        PageInfo pageInfo=new PageInfo(petList);
        return pageInfo;
    }
}
