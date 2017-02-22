import {Component, OnInit, Output, EventEmitter} from "@angular/core";
import {AuthService} from "./shared/services/auth.service";

@Component({
    moduleId: module.id,
    selector: 'my-app',
    templateUrl: './app.component.html'
})
export class AppComponent implements OnInit{

    private isLoading:boolean;
    private isAuthenticated:boolean;

    constructor(private authService:AuthService) {

    }

    ngOnInit(): void {
        this.isLoading=true;

        this.authService.isAuthenticated()
            .subscribe(isAuthenticated => {
                this.isAuthenticated=isAuthenticated;
                this.isLoading=false;
            },
                error=>{
                this.isAuthenticated=false;
            }
        );
    }
}