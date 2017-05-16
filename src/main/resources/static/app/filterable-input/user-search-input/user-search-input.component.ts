import {Component, OnInit} from "@angular/core";
import {SearchService} from "../../shared/services/search.service";
import {User} from "../../shared/models/user.model";
import {FilterableInput} from "../filterable-input";
import {Subscription} from "rxjs";

@Component({
    moduleId: module.id,
    selector: 'user-search-input',
    templateUrl: 'user-search-input.component.html',
    styleUrls: ['user-search-input.component.css']
})
export class UserSearchInputComponent implements FilterableInput, OnInit {

    private searchPage:User[];
    private selectedUser:User;
    private filter:string;
    private isVisible:boolean;
    private isLoading:boolean;
    private searchSubscription:Subscription;
    private MINIMUM_FILTER_LENGTH:number=3;

    constructor(private searchService:SearchService) {
    }

    ngOnInit(): void {
        this.filter="recent";
        this.isVisible=false;
        this.isLoading=true;

        this.initSelectedUser();
        this.getSearchResults();
    }

    ngOnDestroy(): void {
        this.searchSubscription.unsubscribe();
    }

    toggleVisibility(){
        this.isVisible=!this.isVisible;
    }

    setVisibility(isVisible:boolean):void{
        this.isVisible=isVisible;
    }

    getSearchResults(){
        if(this.filter.length<this.MINIMUM_FILTER_LENGTH){//search only if filter has more than 3 signs
            return;
        }

        this.searchService.searchUser(this.filter)
            .subscribe(result => {
                    this.searchPage=result;
                    this.isLoading=false;
                },
                error=>{
                    console.log("Cannot read User", error);
                })
    }

    setSelectedUser(selectedUser:User):void{
        this.selectedUser=selectedUser;
    }

    private initSelectedUser():void{
        this.selectedUser=new User();
        this.selectedUser.firstName="";
        this.selectedUser.lastName="";
    }

    updateFilterValue(filterValue:string){
        this.filter=filterValue;
    }
}