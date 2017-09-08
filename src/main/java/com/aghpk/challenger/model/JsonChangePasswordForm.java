package com.aghpk.challenger.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JsonChangePasswordForm {

    String oldPassword;
    String newPassword;
    String matchingPassword;
}
