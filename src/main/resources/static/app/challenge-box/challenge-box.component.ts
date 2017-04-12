import {Component, OnInit} from "@angular/core";
import {ChallengesService} from "../shared/services/challenges.service"
import {Challenge} from "../shared/models/challenges.model";

@Component({
    moduleId: module.id,
    selector: 'challenge-box',
    templateUrl: './challenge-box.component.html',
    styleUrls: ['challenge-box.component.css'],
    providers: [ChallengesService]
})
export class ChallengeBoxComponent implements OnInit{

   // private challengeDetails: Challenge;
    private isLoading: boolean;
    private challengeList: Array<Challenge>;

    constructor(private challengesService: ChallengesService) {
    }

    // ngOnInit(): void {
    //     this.isLoading=true;
    //     console.log("wchodzi tu");
    //     this.challengesService.getUserChallenges()
    //         .subscribe(challenge =>{
    //             console.log("challenge content");
    //             console.log(challenge);
    //             this.challengeDetails = challenge;
    //             this.isLoading = false;
    //             },
    //             error=>{
    //                 console.log("Cannot read challenge");
    //                 console.log(error);
    //             }
    //         );
    // }

    ngOnInit(): void {
        this.isLoading=true;
        console.log("wchodzi tu");
        this.challengesService.getAllChallenges()
            .subscribe(challenge =>{
                    console.log("challenge content chuuu")
                    this.challengeList = challenge;
                    console.log(challenge);
                    console.log(this.challengeList);
                    this.isLoading = false;
                },
                error=>{
                    console.log("Cannot read challenge");
                    console.log(error);
                }
            );
    }


}