import {Component, OnInit, OnDestroy, ViewChild} from "@angular/core";
import {UserRepository} from "../shared/repository/user.repository";
import {User} from "../shared/models/user.model";
import {ChallengeSearchInputComponent} from "../filterable-input/challenge-search-input/challenge-search-input.component";
import {Subscription} from "rxjs/Subscription";
import {Modal} from "../shared/models/modal";
import {FileUploadService} from "../shared/services/fileUpload.service";

@Component({
    moduleId: module.id,
    selector: 'user-panel',
    templateUrl: './user-panel.component.html',
    styleUrls: ['user-panel.component.css'],
    providers: [ChallengeSearchInputComponent]
})
export class UserPanelComponent implements OnInit, OnDestroy{

    @ViewChild('avatarModal')
    modal: Modal;

    private userDetails: User;
    private isLoading:boolean;
    private loggedUserSubscription:Subscription;
    private avatarUserSubscription: Subscription;
    constructor(private userService: UserRepository, private fileUploadService: FileUploadService)  {
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

        this.avatarUserSubscription = this.fileUploadService.changedAvatarObservable.subscribe(() => {
            this.modal.close();
            $("#user-profile-image").attr('src', 'avatars\\user\\' + this.userDetails.id + '.jpg?' + new Date().getTime());
        });
    }

    ngOnDestroy(){
        this.loggedUserSubscription.unsubscribe();
        this.avatarUserSubscription.unsubscribe();
    }
}