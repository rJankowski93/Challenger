import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs/Rx";
import 'rxjs/add/operator/map';
import {Challenge} from "../models/challenge.model";

@Injectable()
export class ChallengeService {

    private challengeUrl = "api/challenges";

    constructor(private http: Http) {
    }

    getUserChallenges(): Observable<Challenge> {
        return this.http.get(`${this.challengeUrl}/challenge`).map(res => res.json(),
            error => console.log(error));
    }

    getAllChallenges(): Observable <Array<Challenge>> {
        return this.http.get(`${this.challengeUrl}/list`).map(res => res.json(),
            error => console.log(error));
    }
}