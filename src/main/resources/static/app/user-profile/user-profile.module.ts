import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ModalModule} from "ng2-modal";
import {UserProfileComponent} from "./user-profile.component";

@NgModule({
    imports: [
        CommonModule,
        ModalModule
    ],
    exports: [
        UserProfileComponent
    ],

    declarations: [
        UserProfileComponent
    ],
    schemas: [
        CUSTOM_ELEMENTS_SCHEMA
    ]
})
export class UserProfileModule {
}
