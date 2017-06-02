import {Component, OnInit, Input} from "@angular/core";
import {UserRepository} from "../shared/repository/user.repository";
import {User} from "../shared/models/user.model";
import {Subscription} from "rxjs";

@Component({
    moduleId: module.id,
    selector: 'user-profile',
    templateUrl: './user-profile.component.html',
    styleUrls: ['user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

    @Input('userId')
    userId: number;

    private userSubscription: Subscription;

    private userDetails: User;

    private friendsList: Array<User>;

    constructor(private userService: UserRepository) {
    }

    ngOnInit(): void {
        this.getUser(this.userId);
    }

    userIsReady(): boolean {
        return this.userDetails != null;
    }

    showProfileUser(userId: number) {
        this.getUser(userId);
    }

    private getUser(userId: number) {
        this.userSubscription = this.userService.getUser(userId)
            .subscribe(user => {
                    this.userDetails = user;
                },
                error => {
                    console.log("Cannot read User Details", error);
                }
            );

        this.userService.getUserFriends(userId)
            .subscribe(friend => {
                    this.friendsList = friend;
                },
                error => {
                    console.log("Cannot read challenge", error);
                }
            );
    }

    addToFriend() {
        this.userSubscription = this.userService.addToFriend(this.userDetails.id)
            .subscribe(
                error => {
                    console.log("Cannot add friend", error);
                }
            );
    }

}