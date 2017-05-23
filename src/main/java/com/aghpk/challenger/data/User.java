package com.aghpk.challenger.data;


import com.aghpk.challenger.data.interfaces.Scoreable;
import com.aghpk.challenger.data.point.Point;
import com.aghpk.challenger.model.JsonRegisterForm;
import com.aghpk.challenger.model.Views;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USER")
@AttributeOverrides({
        @AttributeOverride(name = "auditCD", column = @Column(name = "AUDIT_CD", updatable = false)),
        @AttributeOverride(name = "auditMD", column = @Column(name = "AUDIT_MD")),
        @AttributeOverride(name = "auditRD", column = @Column(name = "AUDIT_RD")),
})
@Document(indexName = "user", type = "user" , shards = 1)
public class User extends Audit implements Serializable, Scoreable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "LOGIN")
    @JsonView(Views.Public.class)
    private String login;

    @Column(name = "FIRSTNAME")
    @JsonView(Views.Public.class)
    private String firstName;

    @Column(name = "LASTNAME")
    @JsonView(Views.Public.class)
    private String lastname;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    @JsonView(Views.Public.class)
    private String email;

    @Column(name = "ENABLED")
    private boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @JsonBackReference(value = "user-roles-reference")
    private List<UserRole> roles;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @JsonBackReference(value = "user-point")
    private Set<Point> points;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CREATOR_ID", referencedColumnName = "USER_ID")
    @JsonBackReference(value = "user-challenges-reference")
    private List<Challenge> challenges;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "FRIENDSHIP",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FRIEND_ID", referencedColumnName = "USER_ID"))
    @JsonBackReference(value = "user-friends-reference")
    private List<User> friends;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CHALLENGES_USERS",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHALLENGE_ID", referencedColumnName = "CHALLENGE_ID"))
    @JsonBackReference(value="user-challengesUsers-reference")
    private List<Challenge> challengesUsers;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER_GROUPS_MEMBERSHIP",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID"))
    @JsonBackReference(value = "user-groups-reference")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Group> groups;

    public User(JsonRegisterForm jsonRegisterForm) {
        this.login = jsonRegisterForm.getLogin();
        this.firstName = jsonRegisterForm.getFirstname();
        this.lastname = jsonRegisterForm.getLastname();
        this.password = jsonRegisterForm.getPassword();
        this.email = jsonRegisterForm.getEmail();
    }

    @PrePersist
    public void onPrePersist() {
        setAuditCD(new Date());
    }

    @PreUpdate
    public void onPreUpdate() {
        setAuditMD(new Date());
    }

    @Override
    public String toString() {
        return ("Login: " + login + " Password: " + password);
    }

    public Set<Point> getPoints(){
       return  this.points;
    }
}
