package com.aghpk.challenger.data;


<<<<<<< HEAD
import com.aghpk.challenger.data.interfaces.Scoreable;
import com.aghpk.challenger.data.point.Point;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
=======
import com.aghpk.challenger.data.point.Point;
import com.fasterxml.jackson.annotation.JsonBackReference;
>>>>>>> e87ace2c836317a9264b5699676128532304ff5f
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "CHALLENGE")
@AttributeOverrides({
        @AttributeOverride(name = "auditCD", column = @Column(name = "AUDIT_CD", updatable = false)),
        @AttributeOverride(name = "auditMD", column = @Column(name = "AUDIT_MD")),
        @AttributeOverride(name = "auditRD", column = @Column(name = "AUDIT_RD")),
})
<<<<<<< HEAD
public class Challenge extends Audit implements Scoreable {

=======
@Document(indexName = "challenge", type = "challenge" , shards = 1)
public class Challenge extends Audit implements Scoreable{
>>>>>>> e87ace2c836317a9264b5699676128532304ff5f
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

    @Column(name = "REWARD_TYPE")
    private String rewardType;

    @Column(name = "REWARD_QUANTITY")
    private String rewardQuantity;

    @Column(name = "CREATOR_ID", insertable = false, updatable = false)
    private Long idCreator;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CREATOR_ID")
<<<<<<< HEAD
    @JsonBackReference("user-creator-challenge")
=======
>>>>>>> e87ace2c836317a9264b5699676128532304ff5f
    private User user;

    @ManyToMany(mappedBy = "challengesUsers")
<<<<<<< HEAD
    @JsonBackReference("user-challenge")
    private List<User> users;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CHALLENGE_ID", referencedColumnName = "CHALLENGE_ID")
    @JsonManagedReference("challenge-point")
=======
    @JsonBackReference(value = "challenge-users-reference")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<User> users;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CHALLENGE_ID", referencedColumnName = "CHALLENGE_ID")
    @JsonBackReference(value = "challenge-point")
>>>>>>> e87ace2c836317a9264b5699676128532304ff5f
    private Set<Point> points;

    @PrePersist
    public void onPrePersist() {
        setAuditCD(new Date());
    }

    @PreUpdate
    public void onPreUpdate() {
        setAuditMD(new Date());
    }

<<<<<<< HEAD
    @Override
    public Set<Point> getPoints() {
        return points;
=======
    public Set<Point> getPoints(){
        return  this.points;
>>>>>>> e87ace2c836317a9264b5699676128532304ff5f
    }
}
