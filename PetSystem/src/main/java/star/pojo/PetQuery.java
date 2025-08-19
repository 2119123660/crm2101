package star.pojo;

import lombok.Data;

@Data
public class PetQuery {
    private Integer page;
    private String petBreed;
    private Integer petTypeId;
}
