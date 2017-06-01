import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from "@angular/core";
import {UserPanelComponent} from "./user-panel.component";
import {CommonModule} from "@angular/common";
import {ChallengeSearchInputModule} from "../filterable-input/challenge-search-input/challenge-search-input.module";
import {UserSearchInputModule} from "../filterable-input/user-search-input/user-search-input.module";
import {ModalModule} from "ng2-modal";
import {FileUploadPanelModule} from "../file-upload-panel/file-upload-panel.module";
import {ChallengeCreatorModule} from "../challenge-creator/challenge-creator.module";

@NgModule({
    imports: [
        CommonModule,
        ChallengeSearchInputModule,
        UserSearchInputModule,
        ModalModule,
        FileUploadPanelModule,
        ChallengeCreatorModule
    ],
    exports: [
        UserPanelComponent
    ],

    declarations: [
        UserPanelComponent
    ],
    schemas: [
        CUSTOM_ELEMENTS_SCHEMA
    ]
})
export class UserPanelModule {
}
