import {Component, OnInit} from "@angular/core";

@Component({
    moduleId: module.id,
    selector: 'auth-form',
    templateUrl: './auth-form.component.html',
    styleUrls: ['auth-form.component.css'],
})
export class AuthFormComponent {
    private visibleLoginPage: boolean;

    constructor() {
        this.visibleLoginPage = true;
    }

    //Login page <-> Registration page
    showLoginPage(): void {
        this.visibleLoginPage = true;

    }

    hideLoginPage(): void {
        this.visibleLoginPage = false;
    }
}