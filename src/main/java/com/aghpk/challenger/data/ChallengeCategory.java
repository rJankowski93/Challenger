package com.aghpk.challenger.data;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CHALLENGE_CATEGORY")
public class ChallengeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHALLENGE_CATEGORY_ID")
    private Long id;

    @Column(name = "CHALLENGE_CATEGORY_NAME")
    private String challengeCategoryName;
}
