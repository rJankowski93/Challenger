import {Component, OnInit} from "@angular/core";
import {ChallengeRepository} from "../shared/repository/challenge.repository"
import {Challenge} from "../shared/models/challenge.model";

@Component({
    moduleId: module.id,
    selector: 'challenge-box',
    templateUrl: './challenge-box.component.html',
    styleUrls: ['challenge-box.component.css'],
    providers: [ChallengeRepository]
})
export class ChallengeBoxComponent implements OnInit {

    private isLoading: boolean;
    private challengeList: Array<Challenge>;

    constructor(private challengeService: ChallengeRepository) {
    }

    ngOnInit(): void {
        this.isLoading = true;
        this.challengeService.getAllChallenges()
            .subscribe(challenge => {
                    this.challengeList = challenge;
                    this.isLoading = false;
                },
                error => {
                    console.log("Cannot read challenge");
                    console.log(error);
                }
            );
    }


}