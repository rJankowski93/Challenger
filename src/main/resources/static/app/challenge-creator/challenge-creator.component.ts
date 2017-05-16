import {Component, OnInit} from "@angular/core";
import {ChallengeService} from "../shared/services/challenge.service"
import {Challenge} from "../shared/models/challenge.model";

@Component({
    moduleId: module.id,
    selector: 'challenge-creator',
    templateUrl: './challenge-creator.component.html',
    styleUrls: ['challenge-creator.component.css'],
    providers: [ChallengeService]
})
export class ChallengeCreatorComponent implements OnInit {
    private isLoading: boolean;
    private challenge: Challenge;


    constructor(private challengesService: ChallengeService) {
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

