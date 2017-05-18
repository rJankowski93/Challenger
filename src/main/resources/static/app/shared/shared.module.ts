import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from "@angular/core";
import {UserService} from "./services/user.service";
import {HttpModule} from "@angular/http";
import {AuthService} from "./services/auth.service";
import {SearchService} from "./services/search.service";
import {ClickOutsideDirective} from "./directives/click-outside.directive";

@NgModule({
    providers: [
        UserService,
        AuthService,
        SearchService
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
