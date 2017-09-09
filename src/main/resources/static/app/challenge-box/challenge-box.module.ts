import {NgModule} from "@angular/core";
import {ChallengeBoxComponent} from "./challenge-box.component";
import {CommonModule} from "@angular/common"
import {VideoPlayerModule} from "../video-player/video-player.module";
import {ModalModule} from "ng2-modal";

@NgModule({
    imports: [
        CommonModule,
        VideoPlayerModule,
        ModalModule
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
