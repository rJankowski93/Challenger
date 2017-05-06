import {Component, Input, OnInit, ViewChild, OnDestroy} from "@angular/core";
import {SearchService} from "../../services/search.service";
import {FilterableInput} from "../filterable-input";
import {Subscription} from "rxjs";

@Component({
    moduleId: module.id,
    selector: 'challenge-search-input',
    templateUrl: 'challenge-search-input.component.html',
    styleUrls: ['challenge-search-input.component.css']
})
export class ChallengeSearchInputComponent implements FilterableInput, OnInit, OnDestroy {

    private searchPage;
    private filter:string;
    private isVisible:boolean;
    private isLoading:boolean;
    private searchSubscription:Subscription;

    constructor(private searchService:SearchService) {
    }

    ngOnInit(): void {
        this.filter="recent";
        this.isVisible=false;
        this.isLoading=true;

        this.getSearchResults();
    }

    ngOnDestroy(): void {
        this.searchSubscription.unsubscribe();
    }

    toggleVisibility(){
        this.isVisible=!this.isVisible;
    }

    getSearchResults(){
        this.searchSubscription=this.searchService.searchChallenge(this.filter)
            .subscribe(result => {
                    this.searchPage=result;
                    this.isLoading=false;
                },
                error=>{
                    console.error("Cannot read Challenge", error);
                })
    }
}