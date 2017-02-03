import { Component } from '@angular/core';

@Component({
    moduleId: module.id,
    selector: 'login-panel',
    templateUrl: './login-panel.component.html'
})
export class LoginPanelComponent {

    constructor(){

        console.log("login constructor");
    }
}