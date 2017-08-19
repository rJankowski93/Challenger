import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {ChallengeDetailsComponent} from "./challenge-details.component";

@NgModule({
    imports: [
        CommonModule,
        FormsModule
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

