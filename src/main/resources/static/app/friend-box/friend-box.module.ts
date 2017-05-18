import {NgModule} from "@angular/core";
import {FriendBoxComponent} from "./friend-box.component";
import {CommonModule} from "@angular/common"
<<<<<<< HEAD

@NgModule({
    imports: [
        CommonModule
=======
import {ModalModule} from "ng2-modal";

@NgModule({
    imports: [
        CommonModule,
        ModalModule
>>>>>>> e87ace2c836317a9264b5699676128532304ff5f
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