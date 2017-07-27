import {Component, OnInit, Input} from "@angular/core";
import {UserRepository} from "../shared/repository/user.repository";
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

    constructor(private userRepository: UserRepository, private challengeRepository: ChallengeRepository, private userService: UserService) {
    }

    ngOnInit(): void {
        this.getUserProfile(this.userId);
    }

    userIsReady(): boolean {
        return this.userDetails != null;
    }

    showProfileUser(userId: number) {
        this.getUserProfile(userId);
    }

    private getUserProfile(userId: number) {
        this.userSubscription = this.userRepository.getUser(userId)
            .subscribe(user => {
                    this.userDetails = user;
                },
                error => {
                    console.log("Cannot read User Details", error);
                }
            );

        this.userRepository.getUserFriends(userId)
            .subscribe(friend => {
                    this.friendsList = friend;
                },
                error => {
                    console.log("Cannot read challenge", error);
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

        this.userRepository.getFriendsForLoggedUser()
            .subscribe(friends => {
                    this.friendsListForLoggedUser = friends;
                },
                error => {
                    console.log("Cannot read friends", error);
                }
            );
    }

    private addToFriend(): void {
        this.userService.addToFriend(this.userDetails.id);
    }

    private isFriend(): boolean {
        return this.userService.isFriend(this.friendsListForLoggedUser, this.userDetails.id);
    }
}