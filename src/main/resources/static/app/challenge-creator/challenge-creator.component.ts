import {Component, OnInit} from "@angular/core";
import {ChallengeRepository} from "../shared/repository/challenge.repository"
import {Challenge} from "../shared/models/challenge.model";
import {ChallengeCategory} from "../shared/models/challengeCategory.model";

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
    private challengeCategoryList: Array<ChallengeCategory>;

    constructor(private challengesService: ChallengeRepository) {
    }

    ngOnInit(): void {
        this.isLoading = true;
        this.challenge = new Challenge();

        this.challenge.name = "insert name";
        this.challenge.category = "select category of challenge";
        this.challenge.description = "insert description";

        this.challengesService.getAllChallengeCategories()
            .subscribe(challengeCategory => {
                    this.challengeCategoryList = challengeCategory;
                    this.isLoading = false;
                    console.log(challengeCategory);
                },
                error => {
                    console.log("Cannot read challenge");
                    console.log(error);
                }
            );
    }

    onSubmit() {
        this.challengesService.addChallenge(this.challenge)
            .subscribe(challenge => {
                    this.isLoading = false;
                },
                error => {
                    console.log("Cannot read challenge");
                    console.log(error);
                }
            );
    }
}

