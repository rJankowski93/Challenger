import {Component, OnInit} from "@angular/core";
import {NotificationRepository} from "../shared/repository/notification.repository";
import {Notification} from "../shared/models/notification";

@Component({
    moduleId: module.id,
    selector: 'notification-box',
    templateUrl: './notification-box.component.html',
    styleUrls: ['notification-box.component.css']
})
export class NotificationBoxComponent implements OnInit {

    private isLoading: boolean;
    private notificationList: Array<Notification>;
    private userId: number;

    constructor(private notificationService: NotificationRepository) {
    }

    ngOnInit(): void {
        this.isLoading = true;
        this.notificationService.getNotifications(this.userId)
            .subscribe(notification => {
                    this.notificationList = notification;
                    this.isLoading = false;
                },
                error => {
                    console.log("Cannot read notification", error);
                }
            );
    }


}