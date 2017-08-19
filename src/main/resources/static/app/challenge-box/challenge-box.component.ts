import {Component, OnInit} from "@angular/core";
import {Challenge} from "../shared/models/challenge.model";
import {ChallengeService} from "../shared/services/challenge.service";

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


}