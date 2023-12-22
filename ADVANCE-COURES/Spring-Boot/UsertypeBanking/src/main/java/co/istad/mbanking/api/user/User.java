package co.istad.mbanking.api.user;

import lombok.Data;

@Data
public class User {
    private String name;
    private int id;
    private String gender;
    private String oneSignal;
    private Boolean isDeleted;
    private String studentCard;
    private Boolean isStudent;



}
