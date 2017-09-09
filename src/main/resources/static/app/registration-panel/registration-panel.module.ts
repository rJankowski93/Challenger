import {NgModule} from "@angular/core";
import {RegistrationPanelComponent} from "./registration-panel.component";
import { CommonModule } from '@angular/common';

@NgModule({
    imports: [
        CommonModule
    ],
    exports: [
        RegistrationPanelComponent
    ],

    declarations: [
        RegistrationPanelComponent
    ]
})
export class RegistrationPanelModule {
}
