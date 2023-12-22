package com.example.spring4mbankingapisasu.user;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int id;
    private String gender;
    private String onesignal;
    private Boolean isDeleted;
    private String studentCard;
    private Boolean isStudent;

    // Auth feature info
    private String email;
    private String password;
    private Boolean isVerified;
    private String verifiedCode;

    //User has roles
    private List<Role> roles;
}
