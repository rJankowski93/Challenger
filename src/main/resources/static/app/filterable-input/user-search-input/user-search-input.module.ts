import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ModalModule} from "ng2-modal";
import {UserSearchInputComponent} from "./user-search-input.component";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
    imports: [
        CommonModule,
        ModalModule,
        SharedModule
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