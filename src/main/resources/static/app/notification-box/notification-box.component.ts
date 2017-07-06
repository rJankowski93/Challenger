import {Component, OnInit, Input} from "@angular/core";
import {NotificationRepository} from "../shared/repository/notification.repository";
import {Notification} from "../shared/models/notification";
import {$WebSocket} from "angular2-websocket";
import {UserRepository} from "../shared/repository/user.repository";
import {User} from "../shared/models/user.model";
import {Subscription} from "rxjs";

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
export class NotificationBoxComponent {


    private userDetails: User;
    private loggedUserSubscription: Subscription;

    counter: string = 'not known';
    ws: $WebSocket;

    constructor(private userRepository: UserRepository,) {
        this.loggedUserSubscription = this.userRepository.getLoggedInUserData()
            .subscribe(user => {
                    this.userDetails = user;
                },
                error => {
                    console.log("Cannot read User Details", error);
                }
            );

        //this.ws = new $WebSocket("ws://localhost:8088/counter/"+this.userDetails.id);
    }

    subscribe($event) {


        console.log("trying to subscribe to ws");
        this.ws = new $WebSocket("ws://localhost:8080/counter/" + this.userDetails.id);
        this.ws.send("Hello");
        this.ws.getDataStream().subscribe(
            res => {
                var count = JSON.parse(res.data).value;
                console.log('Got: ' + count);
                this.counter = count;
            },
            function (e) {
                console.log('Error: ' + e.message);
            },
            function () {
                console.log('Completed');
            }
        );
    }

}