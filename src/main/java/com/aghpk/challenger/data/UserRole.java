package com.aghpk.challenger.data;

import javax.persistence.*;

@Entity(name = "USER_ROLE")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ROLE")
    private Long idRole;

    @Column(name = "ID_USER")
    private String idUser;

    @Column(name = "ROLE")
    private String role;

    @OneToOne(fetch=FetchType.LAZY, mappedBy="userRole")
    private User user;
}
