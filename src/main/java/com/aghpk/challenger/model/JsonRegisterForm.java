package com.aghpk.challenger.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JsonRegisterForm {

    private String login;
    private String firstName;
    private String lastName;
    private String password;
    private String matchingPassword;
    private String email;

}
