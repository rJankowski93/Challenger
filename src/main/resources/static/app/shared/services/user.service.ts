import {Injectable} from "@angular/core";
import "rxjs/add/operator/map";
import {Subscription} from "rxjs";
import {UserRepository} from "../repository/user.repository";

@Injectable()
export class UserService{

    private userSubscription: Subscription;

    constructor(private userRepository: UserRepository){
    }

    public addToFriend(userId:number) {
        this.userSubscription = this.userRepository.addToFriend(userId)
            .subscribe(
                result => {},
                error => {
                    console.log("Cannot add friend", error);
                }
            );
    }

    public isFriend(loggedUserFriends, userDetailsId): boolean {
        if (loggedUserFriends == null) {
            return false
        }
        return loggedUserFriends.some(x => x.id === userDetailsId);
    }
}