import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {ChallengeDetailsComponent} from "./challenge-details.component";
import {ModalModule} from "ng2-modal";

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        ModalModule
    ],
    exports: [
        ChallengeDetailsComponent
    ],

    declarations: [
        ChallengeDetailsComponent
    ]
})
export class ChallengeDetailsModule {
}

