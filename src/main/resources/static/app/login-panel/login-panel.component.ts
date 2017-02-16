import {Component} from "@angular/core";

@Component({
    moduleId: module.id,
    selector: 'login-panel',
    templateUrl: './login-panel.component.html',
    styleUrls: ['login-panel.component.css']
})
export class LoginPanelComponent {

    constructor() {

        console.log("login constructor");
    }
}