package com.aghpk.challenger.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity(name = "USER_ROLE")
public class UserRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ROLE")
    Long id_role;

    @Column(name = "ID_USER", nullable = false)
    Long id_user;

    @Column(name="ROLE")
    String role;
}
