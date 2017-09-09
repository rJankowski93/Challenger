import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ModalModule} from "ng2-modal";
import {SearchInputComponent} from "./search-input.component";
import {SharedModule} from "../shared/shared.module";

@NgModule({
    imports: [
        CommonModule,
        ModalModule,
        SharedModule
    ],
    exports: [
        SearchInputComponent
    ],
    declarations: [
        SearchInputComponent
    ]
})
export class SearchInputModule {
}