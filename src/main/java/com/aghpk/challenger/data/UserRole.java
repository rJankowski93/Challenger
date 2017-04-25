package com.aghpk.challenger.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USER_ROLE")
public class UserRole {

    public interface ROLE {
        String USER = "ROLE_USER";
        String ADMIN = "ROLE_ADMIN";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Long id;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "USER_ID", insertable = false, updatable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

    public UserRole(String role) {
        this.role = role;
    }
}
