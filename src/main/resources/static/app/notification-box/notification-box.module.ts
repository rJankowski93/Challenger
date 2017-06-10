import {NgModule} from "@angular/core";
import {NotificationBoxComponent} from "./notification-box.component";
import {CommonModule} from "@angular/common"

@NgModule({
    imports: [
        CommonModule
    ],
    exports: [
        NotificationBoxComponent
    ],

    declarations: [
        NotificationBoxComponent
    ]
})
export class NotificationBoxModule {
}
