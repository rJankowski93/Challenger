import {NgModule} from "@angular/core";
import {LoginPanelModule} from "../login-panel/login-panel.module";
import {RegistrationPanelModule} from "../registration-panel/registration-panel.module";
import {AuthFormComponent} from "./auth-form.component";
import {CommonModule} from "@angular/common";

@NgModule({
    imports: [
        LoginPanelModule,
        RegistrationPanelModule,
        CommonModule
    ],
    exports: [
        AuthFormComponent
    ],

    declarations: [
        AuthFormComponent
    ]
})
export class AuthFormModule {
}
