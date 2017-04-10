import {Injectable} from "@angular/core";
import {Http, URLSearchParams} from "@angular/http";
import {Observable} from "rxjs/Rx";
import 'rxjs/add/operator/map';
import {User} from "../models/user.model";

@Injectable()
export class SearchService{

    private FILTER_PARAM="filter";
    private searchUsersUrl = "api/search";

    constructor(private http:Http){
    }

    searchChallenge(filter:string): Observable<User>{
        let searchParams=new URLSearchParams();
        searchParams.set(this.FILTER_PARAM, filter);

        return this.http.get(`${this.searchUsersUrl}/shortlist/challenges`, { search: searchParams })
            .map(res => res.json(),
            error=> console.log(error));
    }

    searchUser(filter:string): Observable<User>{
        let searchParams=new URLSearchParams();
        searchParams.set(this.FILTER_PARAM, filter);

        return this.http.get(`${this.searchUsersUrl}/shortlist/users`, { search: searchParams })
            .map(res => res.json(),
                error=> console.log(error));
    }
}