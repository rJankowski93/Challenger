import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs/Rx";
import 'rxjs/add/operator/map';
import {User} from "../models/user.model";

@Injectable()
export class UserService{

    private userUrl = "api/user";

    constructor(private http:Http){
    }

    // getLoggedInUserData(): Observable<User> {
    //     // return this.http.get(`${this.userUrl}/authentication`).map(res => res.json(),
    //     //         error=> console.log(error));
    // }
}