import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from "@angular/core";
import {UserService} from "./services/user.service";
import {HttpModule} from "@angular/http";
import {AuthRepository} from "./repository/auth.repository";
import {SearchRepository} from "./repository/search.repository";
import {ClickOutsideDirective} from "./directives/click-outside.directive";
import {FileUploadService} from "./services/fileUpload.service";
import {NotificationService} from "./services/notification.service";
import {ChallengeService} from "./services/challenge.service";

@NgModule({
    providers: [
        UserService,
        AuthRepository,
        SearchRepository,
        FileUploadService,
        NotificationService,
        ChallengeService
    ],
    imports: [
        HttpModule
    ],
    declarations: [
      ClickOutsideDirective
    ],
    exports: [
      ClickOutsideDirective
    ],
    schemas: [
        CUSTOM_ELEMENTS_SCHEMA
    ]
})
export class SharedModule {}
