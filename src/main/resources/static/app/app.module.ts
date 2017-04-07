import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {AppComponent} from "./app.component";
import {LoginPanelModule} from "./login-panel/login-panel.module";
import {UserPanelModule} from "./user-panel/user-panel.module";
import {GridPanelModule} from "./grid-panel/grid-panel.module";
import {ChallengeBoxModule} from "./challenge-box/challenge-box.module";
import {CommonModule} from "@angular/common";
import {SharedModule} from "./shared/shared.module";
import {HttpModule} from "@angular/http";
import {RegistrationPanelModule} from "./registration-panel/registration-panel.module";

@NgModule({
    imports: [
        BrowserModule,
        CommonModule,
        HttpModule,
        LoginPanelModule,
        RegistrationPanelModule,
        UserPanelModule,
        GridPanelModule,
        SharedModule,
        ChallengeBoxModule
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
