import {NgModule} from "@angular/core";
import {TopUsersPanelComponent} from "./top-users-panel.component";
import {SharedModule} from "../shared/shared.module";
import {ModalModule} from "ng2-modal";
import {CommonModule} from "@angular/common";

@NgModule({
    imports: [
        CommonModule,
        ModalModule,
        SharedModule
    ],
    exports: [
        TopUsersPanelComponent
    ],
    declarations: [
        TopUsersPanelComponent
    ]
})

export class TopUsersPanelModule {
}
