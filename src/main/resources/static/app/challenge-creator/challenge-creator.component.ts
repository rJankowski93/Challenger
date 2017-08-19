import {Component, OnInit} from "@angular/core";
import {Challenge} from "../shared/models/challenge.model";
import {ChallengeCategory} from "../shared/models/challengeCategory.model";
import {ChallengeService} from "../shared/services/challenge.service";

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
    private challengeCategoryList: Array<ChallengeCategory>;

    constructor(private challengesService: ChallengeService) {
    }

    ngOnInit(): void {
        this.isLoading = true;
        this.challenge = new Challenge();

        this.challengesService.getAllChallengeCategories()
            .subscribe(challengeCategory => {
                    this.challengeCategoryList = challengeCategory;
                    this.isLoading = false;
                },
                error => {
                    console.error("Cannot read challenge", error);
                }
            );
    }

    onSubmit() {
        this.challengesService.addChallenge(this.challenge)
            .subscribe(challenge => {
                    this.isLoading = false;
                },
                error => {
                    console.error("Cannot read challenge", error);
                }
            );
    }
}

