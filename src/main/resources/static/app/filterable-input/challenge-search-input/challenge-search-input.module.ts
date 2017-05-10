import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common"
import {ModalModule} from "ng2-modal";
import {ChallengeSearchInputComponent} from "./challenge-search-input.component";

@NgModule({
    imports: [
        CommonModule,
        ModalModule
    ],
    exports: [
        ChallengeSearchInputComponent
    ],

    declarations: [
        ChallengeSearchInputComponent
    ]
})
export class ChallengeSearchInputModule {
}