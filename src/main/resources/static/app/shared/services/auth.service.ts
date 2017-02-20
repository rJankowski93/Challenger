import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs/Rx";
import 'rxjs/add/operator/first';

@Injectable()
export class AuthService {

    private userUrl = "api/users";

    constructor(private http:Http) {
    }

    isAuthenticated(): Observable<boolean> {
        return this.http.get(`${this.userUrl}/authentication`).map(res => res.json(),
            error=> console.log(error));
    }
}