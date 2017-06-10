import {NgModule} from "@angular/core";
import {ChallengeBoxComponent} from "./challenge-box.component";
import {CommonModule} from "@angular/common"
import {VideoPlayerModule} from "../video-player/video-player.module";

@NgModule({
    imports: [
        CommonModule,
        VideoPlayerModule
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
