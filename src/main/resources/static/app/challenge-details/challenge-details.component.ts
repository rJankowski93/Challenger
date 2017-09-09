import {Component, OnInit, Input} from "@angular/core";
import {Subscription} from "rxjs";
import {Challenge} from "../shared/models/challenge.model";
import {ChallengeService} from "../shared/services/challenge.service";



@Component({
    moduleId: module.id,
    selector: 'challenge-details',
    templateUrl: './challenge-details.component.html',
    styleUrls: ['challenge-details.component.css'],
    providers: [ChallengeService]
})
export class ChallengeDetailsComponent implements OnInit {

    @Input('challengeId')
    challengeId: number;

    private challengeSubscription: Subscription;

    private challengeDetails: Challenge;

    constructor(private challengesService: ChallengeService) {
    }

    ngOnInit(): void {
        this.challengeSubscription = this.challengesService.getChallenge(this.challengeId)
            .subscribe(challenge => {
                    this.challengeDetails = challenge;
                },
                error => {
                    console.log("Cannot read Challenge Details", error);
                }
            );
    }

    challengeIsReady(): boolean {
        return this.challengeDetails != null;
    }

}

