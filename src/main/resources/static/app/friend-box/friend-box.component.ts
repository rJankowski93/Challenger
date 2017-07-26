import {Component, OnInit, Output, EventEmitter} from "@angular/core";
import {User} from "../shared/models/user.model";
import {UserService} from "../shared/services/user.service";

@Component({
    moduleId: module.id,
    selector: 'friend-box',
    templateUrl: './friend-box.component.html',
    styleUrls: ['friend-box.component.css'],
    providers: [UserService]
})
export class FriendBoxComponent implements OnInit {
    @Output()
    showProfileEvent = new EventEmitter();

    private isLoading: boolean;
    private friendsList: Array<User>;

    constructor(private userService: UserService) {
    }

    ngOnInit(): void {
        this.isLoading = true;
        this.userService.getFriendsForLoggedUser()
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