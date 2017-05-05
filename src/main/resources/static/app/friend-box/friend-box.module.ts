import {NgModule} from "@angular/core";
import {FriendBoxComponent} from "./friend-box.component";
import {CommonModule} from "@angular/common"

@NgModule({
    imports: [
        CommonModule
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