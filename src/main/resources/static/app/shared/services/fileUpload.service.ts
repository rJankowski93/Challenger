import { Injectable, Inject } from '@angular/core';
import { Subject }    from 'rxjs/Subject';
@Injectable()
export class FileUploadService {


    private changedAvatar = new Subject<any>();

    changedAvatarObservable = this.changedAvatar.asObservable();

    constructor(){}

    public changeAvatar(data: any) {
        if (data) {
            this.changedAvatar.next(data);
        }
    }
}