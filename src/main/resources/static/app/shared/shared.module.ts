import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from "@angular/core";
import {UserService} from "./services/user.service";
import {HttpModule} from "@angular/http";
import {AuthRepository} from "./repository/auth.repository";
import {SearchRepository} from "./repository/search.repository";
import {ClickOutsideDirective} from "./directives/click-outside.directive";
import {FileUploadService} from "./services/fileUpload.service";
import {ChallengeRepository} from "./repository/challenge.repository";
import {NotificationService} from "./services/notification.service";

@NgModule({
    providers: [
        UserService,
        AuthRepository,
        SearchRepository,
        FileUploadService,
        ChallengeRepository,
        NotificationService
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
