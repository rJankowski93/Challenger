package com.aghpk.challenger.data;

import com.aghpk.challenger.data.interfaces.Scoreable;
import com.aghpk.challenger.data.point.Point;
import com.aghpk.challenger.tools.LocalDateTimeConverter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
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
@Document(indexName = "challenge", type = "challenge", shards = 1)
public class Challenge extends Audit implements Scoreable {

    public enum Status {//the same in notification-box.component.ts -> ChallengeStatus
        WAITING_FOR_APPROVAL,
        IN_PROGRESS,
        DONE,
        FAILED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHALLENGE_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "REWARD_TYPE")
    private String rewardType;

    @Column(name = "REWARD_QUANTITY")
    private String rewardQuantity;

    @Column(name = "CREATOR_ID", insertable = false, updatable = false)
    private Long creatorId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CREATOR_ID")
    private User creator;

    @Column(name = "SUBJECT_ID", insertable = false, updatable = false)
    private Long subjectId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SUBJECT_ID")
    private User subject;

    @Column(name = "VOTERS")
    private String voters;

    @Column(name = "POINTS_QUANTITY")
    private Long pointsQuantity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CHALLENGE_ID", referencedColumnName = "CHALLENGE_ID")
    @JsonBackReference(value = "challenge-point")
    private Set<Point> points;

    @Column(name = "END_DATE")
    @Convert(converter = LocalDateTimeConverter.class)
    //TODO remove the adnotation
    @JsonIgnore
    private LocalDateTime endDate;

    @Column(name = "PERIOD_QUANTITY")
    private Long periodQuantity;

    @Column(name = "PERIOD_UNIT")
    @Enumerated(EnumType.STRING)
    private ChronoUnit periodUnit;

    @PrePersist
    public void onPrePersist() {
        setAuditCD(new Date());
    }

    @PreUpdate
    public void onPreUpdate() {
        setAuditMD(new Date());
    }

    public Set<Point> getPoints() {
        return this.points;
    }
}
