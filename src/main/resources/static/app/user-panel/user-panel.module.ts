import {NgModule} from "@angular/core";
import {UserPanelComponent} from "./user-panel.component";
import {CommonModule} from "@angular/common";

@NgModule({
    imports: [
        CommonModule
    ],
    exports: [
        UserPanelComponent
    ],

    declarations: [
        UserPanelComponent
    ]
})
export class UserPanelModule {
}
