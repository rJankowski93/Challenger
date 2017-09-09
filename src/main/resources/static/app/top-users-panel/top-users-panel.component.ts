import {Component, OnInit} from "@angular/core";
import {UserService} from "../shared/services/user.service";
import {User} from "../shared/models/user.model";

@Component({
    moduleId: module.id,
    selector: 'top-users-panel',
    templateUrl: 'top-users-panel.component.html',
    styleUrls: ['top-users-panel.component.css']
})
export class TopUsersPanelComponent implements OnInit{

    private topUsers:Array<User>;

    constructor(private userService: UserService) {
    }

    ngOnInit(): void {
       this.getTopUsers(0,20,"generalPointsQuantity");
    }

    private getTopUsers(pageNo:number, pageSize:number, pointsType:string){
        this.userService.getTopUsers(pageNo, pageSize, pointsType)
            .subscribe(
                users=>{
                    this.topUsers=users;
                },
                error=>{
                    console.error("Cannot get top users", error);
                }
            )
    }
}