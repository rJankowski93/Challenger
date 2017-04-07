package com.aghpk.challenger.data;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CHALLENGE")
@AttributeOverrides({
        @AttributeOverride(name = "auditCD", column = @Column(name = "AUDIT_CD", updatable = false)),
        @AttributeOverride(name = "auditMD", column = @Column(name = "AUDIT_MD")),
        @AttributeOverride(name = "auditRD", column = @Column(name = "AUDIT_RD")),
})
@Document(indexName = "challenge", type = "challenge" , shards = 1)
public class Challenge extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHALLENGE_ID")
    private Long id;

//    @Field(
//            type = FieldType.String,
//            index = FieldIndex.analyzed,
//            searchAnalyzer = "standard",
//            store = true
//    )
    @Column(name = "NAME")
    private String name;

//    @Field(
//            type = FieldType.String,
//            index = FieldIndex.analyzed,
//            searchAnalyzer = "standard",
//            store = true
//    )
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CATEGORY")
    private String catgory;

    @Column(name = "POINTS")
    private Long points;

    @Column(name = "REWARD_TYPE")
    private String rewardType;

    @Column(name = "REWARD_QUANTITY")
    private String rewardQuantity;

    @Column(name = "CREATOR_ID", insertable = false, updatable = false)
    private Long idCreator;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CREATOR_ID")
    private User user;

    @JsonIgnore
    @ManyToMany(mappedBy = "challengesUsers")
    private List<User> users;

    @PrePersist
    public void onPrePersist() {
        setAuditCD(new Date());
    }

    @PreUpdate
    public void onPreUpdate() {
        setAuditMD(new Date());
    }
}
