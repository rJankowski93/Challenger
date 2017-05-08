import {Component, OnInit} from "@angular/core";
import {UserService} from "../shared/services/user.service";
import {User} from "../shared/models/user.model";

@Component({
    moduleId: module.id,
    selector: 'friend-box',
    templateUrl: './friend-box.component.html',
    styleUrls: ['friend-box.component.css'],
    providers: [UserService]
})
export class FriendBoxComponent implements OnInit {

    private isLoading: boolean;
    private friendsList: Array<User>;

    constructor(private userService: UserService) {
    }

    ngOnInit(): void {
        this.isLoading = true;
        this.userService.getUserFriends()
            .subscribe(friend => {
                    this.friendsList = friend;
                    this.isLoading = false;
                },
                error => {
                    console.log("Cannot read challenge");
                    console.log(error);
                }
            );
    }
}