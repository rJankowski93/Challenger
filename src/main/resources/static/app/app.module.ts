import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {AppComponent} from "./app.component";
import {LoginPanelModule} from "./login-panel/login-panel.module";
import {UserPanelModule} from "./user-panel/user-panel.module";
import {GridPanelModule} from "./grid-panel/grid-panel.module";
import {ChallengeBoxModule} from "./challenge-box/challenge-box.module";
import {ChallengeCreatorModule} from "./challenge-creator/challenge-creator.module";
import {CommonModule} from "@angular/common";
import {SharedModule} from "./shared/shared.module";
import {HttpModule} from "@angular/http";
import {RegistrationPanelModule} from "./registration-panel/registration-panel.module";
import {FileUploadPanelModule} from "./file-upload-panel/file-upload-panel.module";
import {FriendBoxModule} from "./friend-box/friend-box.module";
import {ChallengeSearchInputModule} from "./filterable-input/challenge-search-input/challenge-search-input.module";
import {UserSearchInputModule} from "./filterable-input/user-search-input/user-search-input.module";
import {FormsModule} from "@angular/forms";
import {UserProfileModule} from "./user-profile/user-profile.module";
import {TopUsersPanelModule} from "./top-users-panel/top-users-panel.module";
import {NotificationBoxModule} from "./notification-box/notification-box.module";
import {ChallengeDetailsModule} from "./challenge-details/challenge-details.module";
import {ModalModule} from "ng2-modal";
import {AuthFormModule} from "./auth-form/auth-form.module";
import {SearchInputModule} from "./search-input/search-input.module";



@NgModule({
    imports: [
        BrowserModule,
        CommonModule,
        HttpModule,
        SharedModule,
        LoginPanelModule,
        RegistrationPanelModule,
        UserPanelModule,
        GridPanelModule,
        ChallengeBoxModule,
        ChallengeCreatorModule,
        FileUploadPanelModule,
        FriendBoxModule,
        ChallengeSearchInputModule,
        UserSearchInputModule,
        UserPanelModule,
        FormsModule,
        UserProfileModule,
        TopUsersPanelModule,
        NotificationBoxModule,
        ChallengeDetailsModule,
        ModalModule,
        AuthFormModule,
        SearchInputModule
    ],

    declarations: [
        AppComponent
    ],
    bootstrap: [
        AppComponent
    ],
    schemas: [
        CUSTOM_ELEMENTS_SCHEMA
    ]
})
export class AppModule { }
