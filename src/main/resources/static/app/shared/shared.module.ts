import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from "@angular/core";
import {UserRepository} from "./repository/user.repository";
import {HttpModule} from "@angular/http";
import {AuthRepository} from "./repository/auth.repository";
import {SearchRepository} from "./repository/search.repository";
import {ClickOutsideDirective} from "./directives/click-outside.directive";
import {FileUploadService} from "./services/fileUpload.service";

@NgModule({
    providers: [
        UserRepository,
        AuthRepository,
        SearchRepository,
        FileUploadService
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
