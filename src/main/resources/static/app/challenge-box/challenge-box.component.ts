import {Component, EventEmitter, OnInit, Output, ViewChild} from "@angular/core";
import {Challenge} from "../shared/models/challenge.model";
import {ChallengeService} from "../shared/services/challenge.service";
import {Subscription} from "rxjs";
import {Modal} from "../shared/models/modal";

@Component({
    moduleId: module.id,
    selector: 'challenge-box',
    templateUrl: './challenge-box.component.html',
    styleUrls: ['challenge-box.component.css'],
    providers: [ChallengeService]
})
export class ChallengeBoxComponent implements OnInit {

    // @Output()
    // showChallengeDetailsEvent = new EventEmitter();
    @ViewChild('challengeDetailsModal')
    challengeDetailsModal: Modal;

    private isLoading: boolean;
    public currentChalengeId: number;
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


    shareChallenge(challengeId: number) {
        this.challengeSubscription = this.challengeService.shareChallenge(challengeId)
            .subscribe(
                error => {
                    console.log("Cannot share challenge", error);
                }
            );
    }

    isFacebookConnection() {
        this.isFacebookConnection
    }

    showChallengeDetails() {
        this.challengeDetailsModal.open();
    }

    setCurrentChallengeId(currentChallengeId:number) {
        console.log("works");
        this.currentChalengeId = currentChallengeId;
    }


}