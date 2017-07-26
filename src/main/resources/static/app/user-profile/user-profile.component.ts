import {Component, OnInit, Input} from "@angular/core";
import {User} from "../shared/models/user.model";
import {Subscription} from "rxjs";
import {Challenge} from "../shared/models/challenge.model";
import {ChallengeRepository} from "../shared/repository/challenge.repository";
import {UserService} from "../shared/services/user.service";

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

    private challengesList: Array<Challenge>;

    private friendsListForLoggedUser: Array<User>;

    constructor(private userService: UserService,
                private challengeRepository: ChallengeRepository) {
    }

    ngOnInit(): void {
        console.log(this.userId);
        this.getUserProfile(this.userId);
    }

    userIsReady(): boolean {
        return this.userDetails != null;
    }

    showProfileUser(userId: number) {
        this.getUserProfile(userId);
    }

    private getUserProfile(userId: number) {
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
                    console.log("Cannot read friends", error);
                }
            );

        this.challengeRepository.getUserChallenges(userId)
            .subscribe(challenge => {
                    this.challengesList = challenge;
                },
                error => {
                    console.log("Cannot read challenge", error);
                }
            );

        this.userService.getFriendsForLoggedUser()
            .subscribe(friend => {
                    this.friendsListForLoggedUser = friend;
                },
                error => {
                    console.log("Cannot read friends", error);
                }
            );
    }

    private inviteFriend() {
        this.userSubscription = this.userService.inviteFriend(this.userDetails.id)
            .subscribe(
                error => {
                    console.log("Cannot add friend", error);
                }
            );
    }

    private removeFriend() {
        this.userSubscription = this.userService.removeFriend(this.userDetails.id)
            .subscribe(
                error => {
                    console.log("Cannot remove friend", error);
                }
            );
    }

    private isFriend() {
        if (this.friendsListForLoggedUser == null || this.userDetails == null) {
            return false
        }
        return this.friendsListForLoggedUser.some(x => x.id === this.userDetails.id);
    }

}