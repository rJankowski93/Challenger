package com.aghpk.challenger.data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "GROUP")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_GROUP")
    private Long idGroup;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "groups")
    private List<User> users;
}
