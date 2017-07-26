import {Component, OnInit} from "@angular/core";
import {AuthRepository} from "./shared/repository/auth.repository";

@Component({
    moduleId: module.id,
    selector: 'challenger-app',
    templateUrl: './app.component.html',
    styleUrls: ['app.component.css']
})
export class AppComponent implements OnInit {

    contentTypeEnum: any = ContentType;

    private isLoading: boolean;
    private isAuthenticated: boolean;
    private visibleLoginPage: boolean;
    private mainContentSection: ContentType;
    private newNotification: boolean;
    userId: number;


    constructor(private authService: AuthRepository) {

    }

    ngOnInit(): void {
        this.isLoading = true;
        this.visibleLoginPage = true;
        this.mainContentSection=ContentType.CHALLENGES;
        this.newNotification = false;
        this.authService.isAuthenticated()
            .subscribe(isAuthenticated => {
                    this.isAuthenticated = isAuthenticated;
                    this.isLoading = false;
                },
                error => {
                    this.isAuthenticated = false;
                }
            );

    }

    //Login page <-> Registration page
    showLoginPage(): void {
        this.visibleLoginPage = true;
    }

    hideLoginPage(): void {
        this.visibleLoginPage = false;
    }

    //Challenges list <-> Friends list <-> Profile user
    showList(contentType: ContentType): void {
        this.mainContentSection = contentType;
    }

    showProfile(userId: number) {
        this.mainContentSection = ContentType.PROFILE;
        this.userId = userId;
    }

    showNewNotification(message: string) {
        this.newNotification = true;
    }

    readNotification() {
        this.newNotification = false;
    }
}

export enum ContentType {
    CHALLENGES,
    FRIENDS,
    PROFILE,
    NOTIFICATIONS
}