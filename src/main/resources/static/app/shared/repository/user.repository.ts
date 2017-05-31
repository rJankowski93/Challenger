import {Injectable} from "@angular/core";
import {Http, URLSearchParams} from "@angular/http";
import {Observable} from "rxjs/Rx";
import 'rxjs/add/operator/map';
import {User} from "../models/user.model";

@Injectable()
export class UserRepository{

    private static PAGE_NO:string="pageNo";
    private static PAGE_SIZE:string="pageSize";
    private static POINTS_TYPE:string="pointsType"
    private static USER_API_URL = "api/users";

    constructor(private http:Http){
    }

    getLoggedInUserData(): Observable<User>{
        return this.http.get(`${UserRepository.USER_API_URL}/logged/details`).map(res => res.json(),
                error=> console.log(error));
    }

    getUserFriends(): Observable <Array<User>> {
        return this.http.get(`${UserRepository.USER_API_URL}/friends`).map(res => res.json(),
            error => console.log(error));
    }

    getTopUsers(pageNo, pageSize, pointsType): Observable <Array<User>> {
        let searchParams=new URLSearchParams();
        searchParams.set(UserRepository.PAGE_NO, pageNo);
        searchParams.set(UserRepository.PAGE_SIZE, pageSize);
        searchParams.set(UserRepository.POINTS_TYPE, pointsType);

        return this.http.get(`${UserRepository.USER_API_URL}/top`, { search: searchParams })
            .map(res => res.json(),
                error=> console.error(error));
    }
}