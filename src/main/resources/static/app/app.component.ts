import {Component, OnInit} from "@angular/core";
import {AuthRepository} from "./shared/repository/auth.repository";

@Component({
    moduleId: module.id,
    selector: 'challenger-app',
    templateUrl: './app.component.html'
})
export class AppComponent implements OnInit{

    private isLoading:boolean;
    private isAuthenticated:boolean;
    private visibleLoginPage:boolean;

    constructor(private authService:AuthRepository) {

    }

    ngOnInit(): void {
        this.isLoading=true;
        this.visibleLoginPage=true;
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

    showLoginPage(): void {
        this.visibleLoginPage=true;
    }

    hideLoginPage(): void {
        this.visibleLoginPage=false;
    }
}