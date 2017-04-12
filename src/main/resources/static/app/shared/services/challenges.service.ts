import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs/Rx";
import 'rxjs/add/operator/map';
import {Challenge} from "../models/challenges.model";

@Injectable()
export class ChallengesService{

    private challengeUrl = "api/challenges";

    constructor(private http:Http){
    }

    getUserChallenges(): Observable<Challenge>{
        console.log("debug -> tuu");
        // console.log(this.http.get(`${this.challengeUrl}/challenge`).map(res => res.json()));
        return this.http.get(`${this.challengeUrl}/challenge`).map(res => res.json(),
            error=> console.log(error));
    }

    getAllChallenges(): Observable <Array<Challenge>>{
        console.log("Przyjete w angularze");
        console.log(this.http.get(`${this.challengeUrl}/list`).map(res => res.json()));
        console.log("Po przyjeciu");
        return this.http.get(`${this.challengeUrl}/list`).map(res => res.json(),
            error=> console.log(error));
    }
}