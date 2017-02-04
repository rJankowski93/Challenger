package com.aghpk.challenger.data;

import javax.persistence.*;

@Entity(name = "GROUP")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_GROUP")
    Long id;

    @Column(name = "NAME")
    String name;
}
