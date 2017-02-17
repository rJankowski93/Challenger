import {Component, OnInit} from "@angular/core";
import {AuthService} from "./shared/services/auth.service";

@Component({
    moduleId: module.id,
    selector: 'my-app',
    templateUrl: './app.component.html'
})
export class AppComponent implements OnInit{

    private isAuthenticated:boolean;

    constructor(private authService:AuthService) {

    }

    ngOnInit(): void {
        this.authService.isAuthenticated()
            .subscribe(isAuthenticated => {
                this.isAuthenticated=isAuthenticated;
            },
                error=>{
                this.isAuthenticated=false;
            }
        );
    }
}