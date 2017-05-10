import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ModalModule} from "ng2-modal";
import {UserSearchInputComponent} from "./user-search-input.component";

@NgModule({
    imports: [
        CommonModule,
        ModalModule
    ],
    exports: [
        UserSearchInputComponent
    ],

    declarations: [
        UserSearchInputComponent
    ]
})
export class UserSearchInputModule {
}