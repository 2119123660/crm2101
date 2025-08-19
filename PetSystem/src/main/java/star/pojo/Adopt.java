package star.pojo;

import lombok.Data;

@Data
public class Adopt {
    Integer adoptId;
    Integer adoptUserId;
    Integer adoptPetId;
    String adoptDate;
    User adoptUser;
    Pet adoptPet;
}
