import {NgModule, CUSTOM_ELEMENTS_SCHEMA}      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }   from './app.component';
import {LoginPanelModule} from "./login-panel/login-panel.module";
import {CommonModule} from "@angular/common";

@NgModule({
    imports: [
                BrowserModule,
                CommonModule,
                LoginPanelModule
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
