import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ModalModule} from "ng2-modal";
import {ChallengeSearchInputComponent} from "./challenge-search-input.component";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
    imports: [
        CommonModule,
        ModalModule,
        SharedModule
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