import {Component, OnInit, Output, EventEmitter} from "@angular/core";
import {UserRepository} from "../shared/repository/user.repository";
import {User} from "../shared/models/user.model";

@Component({
    moduleId: module.id,
    selector: 'friend-box',
    templateUrl: './friend-box.component.html',
    styleUrls: ['friend-box.component.css'],
    providers: [UserRepository]
})
export class FriendBoxComponent implements OnInit {
    @Output()
    showProfileEvent = new EventEmitter();

    private isLoading: boolean;
    private friendsList: Array<User>;

    constructor(private userService: UserRepository) {
    }

    ngOnInit(): void {
        this.isLoading = true;
        this.userService.getFriendsForCurrentUser()
            .subscribe(friend => {
                    this.friendsList = friend;
                    this.isLoading = false;
                },
                error => {
                    console.log("Cannot read friends", error);
                }
            );
    }

    showProfileUser(userId: number) {
        this.showProfileEvent.next(userId);
    }
}