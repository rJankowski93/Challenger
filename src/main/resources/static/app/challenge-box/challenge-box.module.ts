import {NgModule} from "@angular/core";
import {ChallengeBoxComponent} from "./challenge-box.component";
import {CommonModule} from "@angular/common"

@NgModule({
    imports: [
      CommonModule
    ],
    exports: [
        ChallengeBoxComponent
    ],

    declarations: [
        ChallengeBoxComponent
    ]
})
export class ChallengeBoxModule {
}
