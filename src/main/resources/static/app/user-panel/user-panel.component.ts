import {Component, OnInit, OnDestroy} from "@angular/core";
import {UserRepository} from "../shared/repository/user.repository";
import {User} from "../shared/models/user.model";
import {ChallengeSearchInputComponent} from "../filterable-input/challenge-search-input/challenge-search-input.component";
import {Subscription} from "rxjs";

@Component({
    moduleId: module.id,
    selector: 'user-panel',
    templateUrl: './user-panel.component.html',
    styleUrls: ['user-panel.component.css'],
    providers: [ChallengeSearchInputComponent]
})
export class UserPanelComponent implements OnInit, OnDestroy{

    private userDetails: User;
    private isLoading:boolean;
    private loggedUserSubscription:Subscription;
    constructor(private userService: UserRepository) {
    }

    ngOnInit(): void {
        this.isLoading=true;

        this.loggedUserSubscription=this.userService.getLoggedInUserData()
            .subscribe(user => {
                    this.userDetails=user;
                    this.isLoading=false;
                },
                error=>{
                    console.log("Cannot read User Details", error);
                }
            );
    }

    ngOnDestroy(){
        this.loggedUserSubscription.unsubscribe();
    }

}