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

    //TODO zunifikowac nazwy np rzeczownik_czasownik
    public enum Type {//the same in notification-box.component.ts -> NotificationType
        FRIEND_INVITE,
        ACCEPT_INVITATION,
        REJECT_INVITATION,
        CHALLENGE_INVITATION,
        CHALLENGE_ACCEPTANCE,
        CHALLENGE_REFUSE,
        CHALLENGE_SUCCESS
    }

    public enum Status {//the same in notification-box.component.ts -> NotificationStatus
        ACTIVE,
        INACTIVE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTIFICATION_ID")
    Long id;

    @Column(name = "Type")
    @Enumerated(EnumType.STRING)
    Type type;

    @Column(name = "Status")
    @Enumerated(EnumType.STRING)
    Status status;

    @Column(name = "MESSAGE")
    String message;

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

    @Column(name = "CHALLENGE_ID", insertable = false, updatable = false)
    private Long challengeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CHALLENGE_ID")
    private Challenge challenge;

    public Notification(Type type, String message, User creator, User subject, Challenge challenge) {
        this.type = type;
        this.message = message;
        this.creator = creator;
        this.subject = subject;
        this.challenge = challenge;
        this.status = Status.ACTIVE;
    }

    @PrePersist
    public void prePersist() {
        setAuditCD(new Date());
    }

    @PreUpdate
    public void preUpdate() {
        setAuditMD(new Date());
    }
}
