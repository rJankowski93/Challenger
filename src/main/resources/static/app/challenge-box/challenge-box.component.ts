import {Component, OnInit} from "@angular/core";
import {Challenge} from "../shared/models/challenge.model";
import {ChallengeService} from "../shared/services/challenge.service";
import {Subscription} from "rxjs";

@Component({
    moduleId: module.id,
    selector: 'challenge-box',
    templateUrl: './challenge-box.component.html',
    styleUrls: ['challenge-box.component.css'],
    providers: [ChallengeService]
})
export class ChallengeBoxComponent implements OnInit {

    private isLoading: boolean;
    private challengeList: Array<Challenge>;
    private challengeSubscription: Subscription;

    constructor(private challengeService: ChallengeService) {
    }

    ngOnInit(): void {
        this.isLoading = true;
        this.challengeService.getAllChallenges()
            .subscribe(challenge => {
                    this.challengeList = challenge;
                    this.isLoading = false;
                },
                error => {
                    console.log("Cannot read challenge", error);
                }
            );
    }

    //TODO zrobiooe na chwile do testow - dofinalnej wersji wzorowac sie na NotificationBoxComponent.acceptChallenge
    acceptChallenge(challengeId: number) {
        this.challengeSubscription = this.challengeService.acceptChallenge(1, challengeId)
            .subscribe(
                error => {
                    console.log("Cannot accept challenge", error);
                }
            );
    }


}