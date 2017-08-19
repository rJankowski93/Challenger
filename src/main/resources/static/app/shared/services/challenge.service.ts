import {Http, RequestOptions, URLSearchParams, Headers, Response} from "@angular/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Challenge} from "../models/challenge.model";
import {ChallengeCategory} from "../models/challengeCategory.model";


@Injectable()
export class ChallengeService {

    private static CHALLENGE_API_URL = "api/challenges";

    constructor(private http: Http) {
    }

    getAllChallenges(): Observable <Array<Challenge>> {
        return this.http.get(`${ChallengeService.CHALLENGE_API_URL}/list`).map(res => res.json(),
            error => console.log(error));
    }

    getChallenge(challengeId: number): Observable<Challenge> {
        let params: URLSearchParams = new URLSearchParams();
        params.set('id', challengeId.toString());
        let requestOptions = new RequestOptions();
        requestOptions.search = params;
        return this.http.get(`${ChallengeService.CHALLENGE_API_URL}/challenge`, requestOptions).map(res => res.json(),
            error => console.log(error));
    }

    getUserChallenges(userId: number): Observable<Array<Challenge>> {
        let params: URLSearchParams = new URLSearchParams();
        params.set('id', userId.toString());
        let requestOptions = new RequestOptions();
        requestOptions.search = params;
        return this.http.get(`${ChallengeService.CHALLENGE_API_URL}/user/challenges`, requestOptions).map(res => res.json(),
            error => console.log(error));
    }

    addChallenge(challenge: Challenge): Observable<Response> {
        let bodyString = JSON.stringify(challenge);
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        return this.http.post(`${ChallengeService.CHALLENGE_API_URL}/add/`, challenge, options)
            .map(res => res,
                error => console.log(error));
    }

    acceptChallenge(notificationId: number, challengeId: number): Observable<Challenge> {
        let params: URLSearchParams = new URLSearchParams();
        params.set('notificationId', notificationId.toString());
        params.set('challengeId', challengeId.toString());
        let requestOptions = new RequestOptions();
        requestOptions.search = params;
        return this.http.get(`${ChallengeService.CHALLENGE_API_URL}/acceptChallenge`, requestOptions).map(res => res.json(),
            error => console.log(error));
    }

    rejectChallenge(notificationId: number, challengeId: number): Observable<Challenge> {
        let params: URLSearchParams = new URLSearchParams();
        params.set('notificationId', notificationId.toString());
        params.set('challengeId', challengeId.toString());
        let requestOptions = new RequestOptions();
        requestOptions.search = params;
        return this.http.get(`${ChallengeService.CHALLENGE_API_URL}/acceptChallenge`, requestOptions).map(res => res.json(),
            error => console.log(error));
    }

    //Challenge categories
    getAllChallengeCategories(): Observable <Array<ChallengeCategory>> {
        return this.http.get(`${ChallengeService.CHALLENGE_API_URL}/categories`).map(res => res.json(),
            error => console.log(error));

    }
}