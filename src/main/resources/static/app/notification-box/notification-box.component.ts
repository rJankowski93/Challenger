import {Component, OnInit} from "@angular/core";
import {Notification} from "../shared/models/notification";
import {$WebSocket} from "angular2-websocket";
import {NotificationService} from "../shared/services/notification.service";

@Component({
    moduleId: module.id,
    selector: 'notification-box',
    templateUrl: './notification-box.component.html',
    styleUrls: ['notification-box.component.css']
})
export class NotificationBoxComponent implements OnInit {

    private notificationsList: Array<Notification>;

    constructor(private notificationService: NotificationService) {
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
}