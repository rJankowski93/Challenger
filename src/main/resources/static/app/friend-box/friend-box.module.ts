import {NgModule} from "@angular/core";
import {FriendBoxComponent} from "./friend-box.component";
import {CommonModule} from "@angular/common"
import {ModalModule} from "ng2-modal";

@NgModule({
    imports: [
        CommonModule,
        ModalModule
    ],
    exports: [
        FriendBoxComponent
    ],

    declarations: [
        FriendBoxComponent
    ]
})
export class FriendBoxModule {
}