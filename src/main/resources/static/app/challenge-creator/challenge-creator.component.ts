import {Component, OnInit} from "@angular/core";
import {ChallengeRepository} from "../shared/repository/challenge.repository";
import {Challenge} from "../shared/models/challenge.model";

@Component({
    moduleId: module.id,
    selector: 'challenge-creator',
    templateUrl: './challenge-creator.component.html',
    styleUrls: ['challenge-creator.component.css'],
    providers: [ChallengeRepository]
})
export class ChallengeCreatorComponent implements OnInit {
    private isLoading: boolean;
    private challenge: Challenge;


    constructor(private challengesService: ChallengeRepository) {
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
                    console.log(challenge);
                    this.isLoading = false;
                },
                error => {
                    console.log("Cannot read challenge", error);
                }
            );
    }

}

