import {NgModule} from "@angular/core";
import {UserPanelComponent} from "./user-panel.component";
import {CommonModule} from "@angular/common";
import {FilterableInputComponent} from "../shared/filterable-input/filterable-input.component";

@NgModule({
    imports: [
        CommonModule
    ],
    exports: [
        UserPanelComponent
    ],

    declarations: [
        UserPanelComponent,
        FilterableInputComponent
    ],
})
export class UserPanelModule {
}
