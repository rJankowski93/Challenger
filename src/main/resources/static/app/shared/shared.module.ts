import {NgModule} from "@angular/core";
import {UserService} from "./services/user.service";
import {HttpModule} from "@angular/http";
import {AuthService} from "./services/auth.service";

@NgModule({
    providers: [
        UserService,
        AuthService
    ],
    imports: [
        HttpModule
    ]
})
export class SharedModule {}
