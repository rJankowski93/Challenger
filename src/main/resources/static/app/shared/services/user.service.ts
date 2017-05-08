import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs/Rx";
import 'rxjs/add/operator/map';
import {User} from "../models/user.model";

@Injectable()
export class UserService{

    private userUrl = "api/users";

    constructor(private http:Http){
    }

    getLoggedInUserData(): Observable<User>{
        console.log(this.http.get(`${this.userUrl}/logged/details`).map(res => res.json()));
        return this.http.get(`${this.userUrl}/logged/details`).map(res => res.json(),
                error=> console.log(error));
    }

    getUserFriends(): Observable <Array<User>> {
        return this.http.get(`${this.userUrl}/friends`).map(res => res.json(),
            error => console.log(error));
    }
}