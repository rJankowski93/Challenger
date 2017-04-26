import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from "@angular/core";
import {UserPanelComponent} from "./user-panel.component";
import {CommonModule} from "@angular/common";
import {ChallengeSearchInputComponent} from "../shared/filterable-input/challenge-search-input/challenge-search-input.component";
import {UserSearchInputComponent} from "../shared/filterable-input/user-search-input/user-search-input.component";

@NgModule({
    imports: [
        CommonModule
    ],
    exports: [
        UserPanelComponent
    ],

    declarations: [
        UserPanelComponent,
        ChallengeSearchInputComponent,
        UserSearchInputComponent
    ],
    schemas: [
        CUSTOM_ELEMENTS_SCHEMA
    ]
})
export class UserPanelModule {
}
