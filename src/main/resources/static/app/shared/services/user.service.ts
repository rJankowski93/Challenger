import {Injectable} from "@angular/core";
import {Http, URLSearchParams, RequestOptions} from "@angular/http";
import {Observable} from "rxjs/Rx";
import 'rxjs/add/operator/map';
import {User} from "../models/user.model";

@Injectable()
export class UserService {

    private static PAGE_NO: string = "pageNo";
    private static PAGE_SIZE: string = "pageSize";
    private static POINTS_TYPE: string = "pointsType"
    private static USER_API_URL = "api/users";

    constructor(private http: Http) {
    }

    /**************** USERS *****************/

    getLoggedInUserData(): Observable<User> {
        return this.http.get(`${UserService.USER_API_URL}/logged/details`).map(res => res.json(),
            error => console.log(error));
    }

    getUser(userId: number): Observable<User> {
        let params: URLSearchParams = new URLSearchParams();
        params.set('id', userId.toString());

        let requestOptions = new RequestOptions();
        requestOptions.search = params;

        return this.http.get(`${UserService.USER_API_URL}/user`, requestOptions).map(res => res.json(),
            error => console.log(error));
    }

    getTopUsers(pageNo, pageSize, pointsType): Observable <Array<User>> {
        let searchParams = new URLSearchParams();
        searchParams.set(UserService.PAGE_NO, pageNo);
        searchParams.set(UserService.PAGE_SIZE, pageSize);
        searchParams.set(UserService.POINTS_TYPE, pointsType);

        return this.http.get(`${UserService.USER_API_URL}/top`, {search: searchParams})
            .map(res => res.json(),
                error => console.error(error));
    }

    /**************** FRIENDS *****************/

    getFriendsForLoggedUser(): Observable <Array<User>> {
        return this.http.get(`${UserService.USER_API_URL}/friends`).map(res => res.json(),
            error => console.log(error));
    }

    getUserFriends(userId: number): Observable <Array<User>> {
        let params: URLSearchParams = new URLSearchParams();
        params.set('id', userId.toString());

        let requestOptions = new RequestOptions();
        requestOptions.search = params;

        return this.http.get(`${UserService.USER_API_URL}/friends`, requestOptions).map(res => res.json(),
            error => console.log(error));
    }

    //TODO zmienic na funkcje bez zwracanego obiektu ale wtedy musi byc w user-profile.component bez subscribe i nie dziala
    removeFriend(friendId: number): Observable<User> {
        let params: URLSearchParams = new URLSearchParams();
        params.set('friendId', friendId.toString());
        let requestOptions = new RequestOptions();
        requestOptions.search = params;
        return this.http.get(`${UserService.USER_API_URL}/removeFriend`, requestOptions).map(res => res.json(),
            error => console.log(error));
    }

    inviteFriend(friendId: number): Observable<User> {
        let params: URLSearchParams = new URLSearchParams();
        params.set('friendId', friendId.toString());
        let requestOptions = new RequestOptions();
        requestOptions.search = params;
        return this.http.get(`${UserService.USER_API_URL}/inviteFriend`, requestOptions).map(res => res.json(),
            error => console.log(error));
    }

    acceptInvitation(friendId: number): Observable<User> {
        let params: URLSearchParams = new URLSearchParams();
        params.set('friendId', friendId.toString());
        let requestOptions = new RequestOptions();
        requestOptions.search = params;
        return this.http.get(`${UserService.USER_API_URL}/acceptInvitation`).map(res => res.json(),
            error => console.log(error));
    }

    public isFriend(loggedUserFriends, userDetailsId): boolean {
        if (loggedUserFriends == null) {
            return false
        }
        return loggedUserFriends.some(x => x.id === userDetailsId);
    }
}