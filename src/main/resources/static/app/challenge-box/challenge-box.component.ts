import {Component} from "@angular/core";

@Component({
    moduleId: module.id,
    selector: 'challenge-box',
    templateUrl: './challenge-box.component.html',
    styleUrls: ['challenge-box.component.css']
})
export class ChallengeBoxComponent {

    constructor() {

        console.log("challenge box constructor");
    }
}