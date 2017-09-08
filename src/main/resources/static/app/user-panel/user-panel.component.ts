import {Component, OnInit, OnDestroy, ViewChild, Output, EventEmitter} from "@angular/core";
import {User} from "../shared/models/user.model";
import {ChallengeSearchInputComponent} from "../filterable-input/challenge-search-input/challenge-search-input.component";
import {Subscription} from "rxjs/Subscription";
import {Modal} from "../shared/models/modal";
import {FileUploadService} from "../shared/services/fileUpload.service";
import {UserService} from "../shared/services/user.service";
import {$WebSocket} from "angular2-websocket";

@Component({
    moduleId: module.id,
    selector: 'user-panel',
    templateUrl: './user-panel.component.html',
    styleUrls: ['user-panel.component.css'],
    providers: [ChallengeSearchInputComponent]
})
export class UserPanelComponent implements OnInit, OnDestroy {

    @ViewChild('avatarModal')
    modal: Modal;

    @Output()
    showNotificationsListEvent = new EventEmitter();

    private userDetails: User;
    private isLoading: boolean;
    private loggedUserSubscription: Subscription;
    private avatarUserSubscription: Subscription;
    private newNotification: boolean;
    webSocket: $WebSocket;

    constructor(private userService: UserService, private fileUploadService: FileUploadService) {
    }

    ngOnInit(): void {
        this.isLoading = true;
        this.newNotification = false;
        this.loggedUserSubscription = this.userService.getLoggedInUserData()
            .subscribe(user => {
                    this.userDetails = user;
                    this.connectWebSocket(user);
                    this.isLoading = false;
                },
                error => {
                    console.log("Cannot read User Details", error);
                }
            );

        this.avatarUserSubscription = this.fileUploadService.changedAvatarObservable.subscribe(() => {
            this.modal.close();
            $("#user-profile-image").attr('src', 'avatars\\user\\' + this.userDetails.id + '.jpg?' + new Date().getTime());
        });

    }

    ngOnDestroy() {
        this.loggedUserSubscription.unsubscribe();
        this.avatarUserSubscription.unsubscribe();
    }

    showNotification() {
        this.newNotification = false;
        this.showNotificationsListEvent.next();
    }

    connectWebSocket(user: User) {
        this.webSocket = new $WebSocket("ws://localhost:8080/notificationSession/" + user.id);
        this.webSocket.send("START");
        //TODO in production set server and port
        this.webSocket.getDataStream().subscribe(
            res => {
                var notification = JSON.parse(res.data).value;
                this.newNotification = true;
            },
            function (e) {
                console.log('Error: ' + e.message);
            },
            function () {
                console.log('Completed');
            }
        );
    }

    changePassword() {
        var data = {};
        data["oldPassword"] = $("#old-password").val();
        data["newPassword"] = $("#new-password").val();
        data["matchingPassword"] = $("#matching-password").val();
        $(document).ready(function () {
            $.ajax({
                method: "POST",
                contentType: "application/json",
                url: "/api/users/changePassword",
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (data) {
                    //display(data);
                    console.log(data);
                },
                error: function (e) {
                    console.log("FAIL", e);
                }
            })

        });
    }

}