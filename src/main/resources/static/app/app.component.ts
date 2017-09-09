import {Component, OnInit, ViewChild} from "@angular/core";
import {AuthRepository} from "./shared/repository/auth.repository";
import {Modal} from "./shared/models/modal";

@Component({
    moduleId: module.id,
    selector: 'challenger-app',
    templateUrl: './app.component.html',
    styleUrls: ['app.component.css']
})
export class AppComponent implements OnInit {

    @ViewChild('avatarModal')
    modal: Modal;

    @ViewChild('createChallengeModal')
    createChallengeModal: Modal;

    @ViewChild('challengeDetailsModal')
    challengeDetailsModal: Modal;

    contentTypeEnum: any = ContentType;

    private isLoading: boolean;
    private isAuthenticated: boolean;

    private mainContentSection: ContentType;
    userId: number;
    challengeId: number;

    constructor(private authService: AuthRepository) {
    }

    ngOnInit(): void {
        this.isLoading = true;
        this.mainContentSection = ContentType.CHALLENGES;
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

    //Challenges list <-> Friends list
    showList(contentType: ContentType): void {
        this.mainContentSection = contentType;
    }

    showProfile(userId: number) {
        this.mainContentSection = ContentType.PROFILE;
        this.userId = userId;
    }

    showChallenge(challengeId: number) {
        this.mainContentSection = ContentType.CHALLENGE;
        this.challengeId = challengeId;
    }

    showAvatarModal() {
        this.modal.open();
    }

    showCreateChallengeModal(){
        this.createChallengeModal.open();
    }

    showChallengeDetailsModal(){
        this.challengeDetailsModal.open();
    }
}

export enum ContentType {
    CHALLENGES,
    CHALLENGE,
    FRIENDS,
    PROFILE,
    NOTIFICATIONS
}
