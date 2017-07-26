package com.aghpk.challenger.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "NOTIFICATION")
@AttributeOverrides({
        @AttributeOverride(name = "auditCD", column = @Column(name = "AUDIT_CD", updatable = false)),
        @AttributeOverride(name = "auditMD", column = @Column(name = "AUDIT_MD")),
        @AttributeOverride(name = "auditRD", column = @Column(name = "AUDIT_RD")),
})
public class Notification extends Audit implements Serializable {

    public enum Type {
        FRIEND_INVITATION,
        FRIEND_ACCEPTANCE,
        CHALLENGE_INVITATION,
        CHALLENGE_ACCEPTANCE,
        CHALLENGE_REFUSE,
        CHALLENGE_SUCCESS
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTIFICATION_ID")
    Long id;

    @Column(name = "Type")
    @Enumerated(EnumType.STRING)
    Type type;

    @Column(name = "MESSAGE")
    String message;

    @Column(name = "DETAILS_LINK")
    String detailsLink;

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

    public Notification(Type type, String message, String detailsLink, User creator, User subject) {
        this.type = type;
        this.message = message;
        this.detailsLink = detailsLink;
        this.creator = creator;
        this.subject = subject;
    }

    @PrePersist
    public void onPrePersist() {
        setAuditCD(new Date());
    }

    @PreUpdate
    public void onPreUpdate() {
        setAuditMD(new Date());
    }
}
