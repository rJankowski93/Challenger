import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions, Response, URLSearchParams} from "@angular/http";
import {Observable} from "rxjs/Rx";
import "rxjs/add/operator/map";
import {Challenge} from "../models/challenge.model";
import {ChallengeCategory} from "../models/challengeCategory.model";

@Injectable()
export class ChallengeRepository {

    private static CHALLENGE_API_URL = "api/challenges";

    constructor(private http: Http) {
    }

    getUserChallenges(userId: number): Observable<Array<Challenge>> {
        let params: URLSearchParams = new URLSearchParams();
        params.set('id', userId.toString());

        let requestOptions = new RequestOptions();
        requestOptions.search = params;

        return this.http.get(`${ChallengeRepository.CHALLENGE_API_URL}/user/challenges`, requestOptions).map(res => res.json(),
            error => console.log(error));
    }

    getAllChallenges(): Observable <Array<Challenge>> {
        return this.http.get(`${ChallengeRepository.CHALLENGE_API_URL}/list`).map(res => res.json(),
            error => console.log(error));

    }

    addChallenge(challenge: Challenge): Observable<Response> {
        let bodyString = JSON.stringify(challenge);
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        return this.http.post(`${ChallengeRepository.CHALLENGE_API_URL}/add/`, challenge, options)
            .map(res => res,
                error => console.log(error));
    }

    //Challenge categories
    getAllChallengeCategories(): Observable <Array<ChallengeCategory>> {
        return this.http.get(`${ChallengeRepository.CHALLENGE_API_URL}/categories`).map(res => res.json(),
            error => console.log(error));

    }

}