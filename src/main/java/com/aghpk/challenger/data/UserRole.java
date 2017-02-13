package com.aghpk.challenger.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity(name = "USER_ROLE")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ROLE")
    private Long id;

    @Column(name = "ID_USER")
    private String idUser;

    @Column(name = "ROLE")
    private String role;

    @OneToOne(fetch=FetchType.LAZY, mappedBy="userRole")
    private User user;
}
