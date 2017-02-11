import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {AppComponent} from "./app.component";
import {CommonModule} from "@angular/common";
import {UserPanelModule} from "./user-panel/user-panel.module";

@NgModule({
    imports: [
        BrowserModule,
        CommonModule,
        UserPanelModule
    ],
    declarations: [
        AppComponent
    ],
    bootstrap: [
        AppComponent
    ],
    schemas: [
        CUSTOM_ELEMENTS_SCHEMA
    ]
})
export class AppModule { }