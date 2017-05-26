import {Injectable} from "@angular/core";
import {Http, URLSearchParams} from "@angular/http";
import {Observable} from "rxjs/Rx";
import 'rxjs/add/operator/map';
import {User} from "../models/user.model";
import {Challenge} from "../models/challenge.model";

@Injectable()
export class SearchService{

    private static FILTER_PARAM:string="filter";
    private static SEARCH_PAGE_PARAM:string="pageNo";
    private static PAGE_SIZE:string="pageSize";
    private static searchUsersUrl = "api/search";

    constructor(private http:Http){
    }

    searchChallenge(filter:string,pageNo, pageSize): Observable<Challenge[]>{
        let searchParams=new URLSearchParams();
        searchParams.set(SearchService.FILTER_PARAM, filter);
        searchParams.set(SearchService.SEARCH_PAGE_PARAM, pageNo);
        searchParams.set(SearchService.PAGE_SIZE, pageSize);

        return this.http.get(`${SearchService.searchUsersUrl}/challenges`, { search: searchParams })
            .map(res => res.json(),
                error=> console.error(error));
    }

    searchUser(filter:string,pageNo, pageSize): Observable<User[]>{
        let searchParams=new URLSearchParams();
        searchParams.set(SearchService.FILTER_PARAM, filter);
        searchParams.set(SearchService.SEARCH_PAGE_PARAM, pageNo);
        searchParams.set(SearchService.PAGE_SIZE, pageSize);

        return this.http.get(`${SearchService.searchUsersUrl}/users`, { search: searchParams })
            .map(res => res.json(),
                error=> console.error(error));
    }
}