package com.aghpk.challenger.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity(name = "GROUP")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GROUP")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "groups", cascade = CascadeType.ALL)
    private List<User> users;
}
