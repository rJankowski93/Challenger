import {Component, OnInit} from "@angular/core";
import {ChallengesService} from "../shared/services/challenges.service"
import {Challenge} from "../shared/models/challenges.model";

@Component({
    moduleId: module.id,
    selector: 'challenge-creator',
    templateUrl: './challenge-creator.component.html',
    styleUrls: ['challenge-creator.component.css'],
    providers: [ChallengesService]
})
export class ChallengeCreatorComponent implements OnInit {
    private isLoading: boolean;
    private challenge: Challenge;


    constructor(private challengesService: ChallengesService) {
    }

    ngOnInit(): void {
        this.isLoading = true;

        this.challenge = new Challenge();

        this.challenge.name = "";
        this.challenge.category = "category";
        this.challenge.description = "desc";
    }

    onSubmit() {
        this.challengesService.addChallenge(this.challenge)
            .subscribe(challenge => {
                    console.log("challenge content chuuu")
                    console.log(challenge);
                    this.isLoading = false;
                },
                error => {
                    console.log("Cannot read challenge");
                    console.log(error);
                }
            );
    }

}

