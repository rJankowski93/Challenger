import {Component, OnInit} from "@angular/core";
import {SearchRepository} from "../../shared/repository/search.repository";
import {User} from "../../shared/models/user.model";
import {FilterableInput} from "../filterable-input";
import {Subscription} from "rxjs";
import {MapUtils} from "../../shared/services/map.utils";

@Component({
    moduleId: module.id,
    selector: 'user-search-input',
    templateUrl: 'user-search-input.component.html',
    styleUrls: ['user-search-input.component.css']
})
export class UserSearchInputComponent implements FilterableInput, OnInit {

    private searchPage:User[];
    private selectedUser:User;
    private usersLongPage:User[];
    private usersListEmpty:boolean=true;
    private filter:string;
    private isVisible:boolean;
    private isLoading:boolean;
    private searchSubscription:Subscription;
    private MINIMUM_FILTER_LENGTH:number=3;

    constructor(private searchService:SearchRepository) {
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

        this.searchService.searchUser(this.filter,0,5)
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

    getMoreUsers(pageNo:number):void{
        this.searchSubscription=this.searchService.searchUser(this.filter,pageNo,6)
            .subscribe(result => {
                    this.usersLongPage=result;
                    this.usersListEmpty=false;
                },
                error=>{
                    console.error("Cannot read Users", error);
                })
    }

    createPageRange(number){
        return MapUtils.createPageRange(number);
    }
}