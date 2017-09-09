import {Injectable} from "@angular/core";
import {Http, URLSearchParams} from "@angular/http";
import {Observable} from "rxjs/Rx";
import 'rxjs/add/operator/map';
import {User} from "../models/user.model";
import {Challenge} from "../models/challenge.model";
import {GlobalSearchResult} from "../models/globalSearchResult.model";

@Injectable()
export class SearchRepository{

    private static FILTER_PARAM:string="filter";
    private static SEARCH_PAGE_PARAM:string="pageNo";
    private static PAGE_SIZE:string="pageSize";
    private static SEARCH_URL = "api/search";

    constructor(private http:Http){
    }

    searchChallenge(filter:string,pageNo, pageSize): Observable<Challenge[]>{
        let searchParams=new URLSearchParams();
        searchParams.set(SearchRepository.FILTER_PARAM, filter);
        searchParams.set(SearchRepository.SEARCH_PAGE_PARAM, pageNo);
        searchParams.set(SearchRepository.PAGE_SIZE, pageSize);

        return this.http.get(`${SearchRepository.SEARCH_URL}/challenges`, { search: searchParams })
            .map(res => res.json(),
                error=> console.error(error));
    }

    searchUser(filter:string,pageNo, pageSize): Observable<User[]>{
        let searchParams=new URLSearchParams();
        searchParams.set(SearchRepository.FILTER_PARAM, filter);
        searchParams.set(SearchRepository.SEARCH_PAGE_PARAM, pageNo);
        searchParams.set(SearchRepository.PAGE_SIZE, pageSize);

        return this.http.get(`${SearchRepository.SEARCH_URL}/users`, { search: searchParams })
            .map(res => res.json(),
                error=> console.error(error));
    }

    searchResult(filter: string, pageNo, pageSize): Observable<GlobalSearchResult> {
        let searchParams = new URLSearchParams();
        searchParams.set(SearchRepository.FILTER_PARAM, filter);
        searchParams.set(SearchRepository.SEARCH_PAGE_PARAM, pageNo);
        searchParams.set(SearchRepository.PAGE_SIZE, pageSize);

        return this.http.get(`${SearchRepository.SEARCH_URL}/global`, {search: searchParams})
            .map(res => res.json(),
                error => console.error(error));
    }
}