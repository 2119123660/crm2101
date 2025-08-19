package star.pojo;

import lombok.Data;

@Data
public class Pet {
    private Integer petId;
    private String petImg;
    private Integer petTypeId;
    private String petBreed;
    private String petColor;
    private String petGender;
    private Double petWeight;
    private String petAge;
    private String petDescr;
    private PetType petType;


}