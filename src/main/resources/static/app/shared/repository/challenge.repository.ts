import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions, Response} from "@angular/http";
import {Observable} from "rxjs/Rx";
import "rxjs/add/operator/map";
import {Challenge} from "../models/challenge.model";

@Injectable()
export class ChallengeRepository {

    private challengeUrl = "api/challenges";

    constructor(private http: Http) {
    }

    getUserChallenge(): Observable<Challenge> {
        return this.http.get(`${this.challengeUrl}/challenge`).map(res => res.json(),
            error => console.log(error));
    }

    getAllChallenges(): Observable <Array<Challenge>> {
        return this.http.get(`${this.challengeUrl}/list`).map(res => res.json(),
            error => console.log(error));

    }

    addChallenge(challenge: Challenge): Observable<Response> {
        let bodyString = JSON.stringify(challenge);
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        return this.http.post(`${this.challengeUrl}/add/`, challenge, options)
            .map(res => res,
                error => console.log(error));
    }

}