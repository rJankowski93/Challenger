package com.aghpk.challenger.data;

import javax.persistence.*;

@Entity(name = "USER_ROLE")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ROLE")
    Long idRole;

    @ForeignKey
    @Column(name = "ID_USER")
    String idUser;

    @Column(name = "ROLE")
    String role;
}
