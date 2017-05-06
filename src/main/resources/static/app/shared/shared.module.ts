import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from "@angular/core";
import {UserService} from "./services/user.service";
import {HttpModule} from "@angular/http";
import {AuthService} from "./services/auth.service";
import {SearchService} from "./services/search.service";

@NgModule({

    providers: [
        UserService,
        AuthService,
        SearchService
    ],
    imports: [
        HttpModule
    ],
    schemas: [
        CUSTOM_ELEMENTS_SCHEMA
    ]
})
export class SharedModule {}
