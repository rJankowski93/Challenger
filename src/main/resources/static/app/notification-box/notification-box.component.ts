import {Component, OnInit, Input, Output, EventEmitter} from "@angular/core";
import {NotificationRepository} from "../shared/repository/notification.repository";
import {Notification} from "../shared/models/notification";
import {$WebSocket} from "angular2-websocket";
import {User} from "../shared/models/user.model";
import {Subscription} from "rxjs";
import {UserService} from "../shared/services/user.service";

@Component({
    moduleId: module.id,
    selector: 'notification-box',
    templateUrl: './notification-box.component.html',
    styleUrls: ['notification-box.component.css']
})
// export class NotificationBoxComponent implements OnInit {

// private isLoading: boolean;
// private notificationList: Array<Notification>;
// private userId: number;
//
// constructor(private notificationService: NotificationRepository) {
// }
//
// ngOnInit(): void {
//     this.isLoading = true;
//     this.notificationService.getNotificationsForLoggedUser()
//         .subscribe(notification => {
//                 this.notificationList = notification;
//                 this.isLoading = false;
//             },
//             error => {
//                 console.log("Cannot read notification", error);
//             }
//         );
// }
export class NotificationBoxComponent implements OnInit {

    @Output()
    newNotification = new EventEmitter();


    private userDetails: User;

    //private userDetails: User;3
    private loggedUserSubscription: Subscription;

    //private newNotifications: boolean;

    webSocket: $WebSocket;

    constructor(private userService: UserService) {
    }

    ngOnInit(): void {
        // this.loggedUserSubscription = this.userService.getLoggedInUserData()
        //     .subscribe(user => {
        //             this.userDetails = user;
        //         },
        //         error => {
        //             console.log("Cannot read User Details", error);
        //         }
        //     );
        //this.newNotifications = false;
        this.loggedUserSubscription = this.userService.getLoggedInUserData()
            .subscribe(user => {
                    this.userDetails = user;
                },
                error => {
                    console.log("Cannot read User Details", error);
                }
            );


    }


    subscribe($event) {
        console.log(this.userDetails);
        this.webSocket = new $WebSocket("ws://localhost:8080/notificationSession/" + this.userDetails.id);
        this.webSocket.send("START");
        //TODO in production set server and port
        this.webSocket.getDataStream().subscribe(
            res => {
                var notification = JSON.parse(res.data).value;
                this.showNewNotifications();
                console.log(notification);
            },
            function (e) {
                console.log('Error: ' + e.message);
            },
            function () {
                console.log('Completed');
            }
        );
    }

    showNewNotifications() {
        this.newNotification.next("todo: Information about notification");
    }
}