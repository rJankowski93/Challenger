import {Injectable} from "@angular/core";
import {Http, URLSearchParams, RequestOptions} from "@angular/http";
import {Observable} from "rxjs/Rx";
import 'rxjs/add/operator/map';
import {User} from "../models/user.model";
import {Notification} from "../models/notification";

@Injectable()
export class NotificationService {

    private static NOTIFICATION_API_URL = "api/notifications";

    constructor(private http: Http) {
    }

    getNotificationsForLoggedUser(): Observable <Array<Notification>> {
        return this.http.get(`${NotificationService.NOTIFICATION_API_URL}/user`).map(res => res.json(),
            error => console.log(error));
    }

    // createNotification(type: string, subjectId: number): Observable<User> {
    //     let params: URLSearchParams = new URLSearchParams();
    //     params.set('type', type);
    //     params.set('subjectId', subjectId.toString());
    //
    //     let requestOptions = new RequestOptions();
    //     requestOptions.search = params;
    //
    //     return this.http.get(`${NotificationService.NOTIFICATION_API_URL}/create`, requestOptions).map(res => res.json(),
    //         error => console.log(error));
    // }
}