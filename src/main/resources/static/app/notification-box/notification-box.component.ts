import {Component, OnInit, EventEmitter, Output} from "@angular/core";
import {Notification} from "../shared/models/notification";
import {$WebSocket} from "angular2-websocket";
import {NotificationService} from "../shared/services/notification.service";
import {Subscription} from "rxjs";
import {UserService} from "../shared/services/user.service";
import {ChallengeService} from "../shared/services/challenge.service";

@Component({
    moduleId: module.id,
    selector: 'notification-box',
    templateUrl: './notification-box.component.html',
    styleUrls: ['notification-box.component.css']
})
export class NotificationBoxComponent implements OnInit {

    @Output("showProfileEvent")
    showProfileEvent = new EventEmitter();

    @Output("showChallengeEvent")
    showChallengeEvent = new EventEmitter();

    private userSubscription: Subscription;

    private challengeSubscription: Subscription;

    private notificationsList: Array<Notification>;

    notificationTypeEnum: any = NotificationType;

    notificationStatusEnum: any = NotificationStatus;

    challengeStatusEnum: any = ChallengeStatus;

    constructor(private notificationService: NotificationService, private userService: UserService, private challengeService: ChallengeService) {
    }

    ngOnInit(): void {
        this.notificationService.getNotificationsForLoggedUser()
            .subscribe(notification => {
                    this.notificationsList = notification;
                },
                error => {
                    console.log("Cannot read notifications", error);
                }
            );
    }

    acceptInvitation(notificationId: number, creatorId: number) {
        //TODO po kliknieciu w ten przycisk status notyfikacji sie zmienia wiec powinny zniknac przyciski Accept i Reject ale nie zniekaja
        // moze ngIf nie jest async czy cos
        this.userSubscription = this.userService.acceptInvitation(notificationId, creatorId)
            .subscribe(
                error => {
                    console.log("Cannot accept invitation", error);
                }
            );
    }

    rejectInvitation(notificationId: number, creatorId: number) {
        //TODO po kliknieciu w ten przycisk status notyfikacji sie zmienia wiec powinny zniknac przyciski Accept i Reject ale nie zniekaja
        //  moze ngIf nie jest async czy cos
        this.userSubscription = this.userService.rejectInvitation(notificationId, creatorId)
            .subscribe(
                error => {
                    console.log("Cannot reject invitation", error);
                }
            );
    }

    acceptChallenge(notificationId: number, challengeId: number) {
        this.challengeSubscription = this.challengeService.acceptChallenge(notificationId, challengeId)
            .subscribe(
                error => {
                    console.log("Cannot accept challenge", error);
                }
            );
    }

    rejectChallenge(notificationId: number, challengeId: number) {
        this.challengeSubscription = this.challengeService.rejectChallenge(notificationId, challengeId)
            .subscribe(
                error => {
                    console.log("Cannot accept challenge", error);
                }
            );
    }

    showProfileUser(creatorId: number) {
        this.showProfileEvent.next(creatorId);
    }

    showChallenge(challengeId: number) {
        this.showChallengeEvent.next(challengeId);
    }
}

export class NotificationType {
    static FRIEND_INVITE = "FRIEND_INVITE";
    static ACCEPT_INVITATION = "ACCEPT_INVITATION";
    static REJECT_INVITATION = "REJECT_INVITATION";
    static CHALLENGE_INVITATION = "CHALLENGE_INVITATION";
    static CHALLENGE_ACCEPTANCE = "CHALLENGE_ACCEPTANCE";
    static CHALLENGE_REFUSE = "CHALLENGE_REFUSE";
    static CHALLENGE_SUCCESS = "CHALLENGE_SUCCESS";
}

export class NotificationStatus {
    static ACTIVE = "ACTIVE";
    static INACTIVE = "INACTIVE";
}


export class ChallengeStatus {
    static WAITING_FOR_APPROVAL = "WAITING_FOR_APPROVAL";
    static IN_PROGRESS = "IN_PROGRESS";
    static DONE = "DONE";
    static FAILED = "FAILED";
}
