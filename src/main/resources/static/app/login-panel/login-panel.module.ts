import {NgModule} from "@angular/core";
import {LoginPanelComponent} from "./login-panel.component";
import {CommonModule} from "@angular/common";

@NgModule({
    imports: [
        CommonModule
    ],
    exports: [
        LoginPanelComponent
    ],

    declarations: [
        LoginPanelComponent
    ]
})
export class LoginPanelModule {
}
