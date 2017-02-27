import {Component, OnInit, OnChanges, Input} from "@angular/core";
import {UserService} from "../shared/services/user.service";
import {User} from "../shared/models/user.model";

@Component({
    moduleId: module.id,
    selector: 'user-panel',
    templateUrl: './user-panel.component.html',
    styleUrls: ['user-panel.component.css']
})
export class UserPanelComponent implements OnInit{

    private userDetails: User;
    private isLoading:boolean;

    constructor(private userService: UserService) {
    }

    ngOnInit(): void {
        this.isLoading=true;

        this.userService.getLoggedInUserData()
            .subscribe(user => {
                    this.userDetails=user;
                    this.isLoading=false;
                },
                error=>{
                    console.log("Cannot read User Details");
                    console.log(error);
                }
            );
    }

}