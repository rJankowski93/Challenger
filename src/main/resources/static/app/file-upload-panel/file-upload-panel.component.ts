import {Component, OnInit} from "@angular/core";
import {FileUploadService} from "../shared/services/fileUpload.service";

@Component({
    moduleId: module.id,
    selector: 'file-upload-panel',
    templateUrl: './file-upload-panel.component.html',
    styleUrls: ['file-upload-panel.component.css']
})
export class FileUploadPanelComponent extends OnInit{
    avatar:any;

    constructor(private fileUploadService: FileUploadService ) {
        super();
    }

    ngOnInit(): void {
       this.avatar="http://stardesign.com.pl/images/member1.jpg";
    }

    onFileChange(fileInput: any){
        this.avatar = fileInput.target.files[0];
        let reader = new FileReader();
        reader.onload = (e: any) => {
            this.avatar = e.target.result;
        }
        reader.readAsDataURL(fileInput.target.files[0]);
    }

    finish(){
        this.fileUploadService.changeAvatar({option: 'onSubmit'});
    }
}