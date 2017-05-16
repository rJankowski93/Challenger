import {NgModule} from "@angular/core";
import {FormsModule}   from '@angular/forms';
import {ChallengeCreatorComponent} from "./challenge-creator.component";
import {CommonModule} from "@angular/common"

@NgModule({
    imports: [
        CommonModule,
        FormsModule
    ],
    exports: [
        ChallengeCreatorComponent
    ],

    declarations: [
        ChallengeCreatorComponent
    ]
})
export class ChallengeCreatorModule {
}

