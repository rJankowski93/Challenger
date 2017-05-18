import {Component, OnInit, OnDestroy} from "@angular/core";
import {SearchService} from "../../shared/services/search.service";
import {FilterableInput} from "../filterable-input";
import {Subscription} from "rxjs";
import {Challenge} from "../../shared/models/challenge.model";

@Component({
    moduleId: module.id,
    selector: 'challenge-search-input',
    templateUrl: 'challenge-search-input.component.html',
    styleUrls: ['challenge-search-input.component.css'],
})
export class ChallengeSearchInputComponent implements FilterableInput, OnInit, OnDestroy {

    private searchPage:Challenge[];
    private selectedChallenge:Challenge;
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

        this.initSelectedChallenge();
        this.getSearchResults();
    }

    ngOnDestroy(): void {
        this.searchSubscription.unsubscribe();
    }

    toggleVisibility():void{
        this.isVisible=!this.isVisible;
    }

    setVisibility(isVisible:boolean):void{
        this.isVisible=isVisible;
    }

    getSearchResults():void{
        if(this.filter.length<this.MINIMUM_FILTER_LENGTH){//search only if filter has more than 3 signs
            return;
        }

        this.searchSubscription=this.searchService.searchChallenge(this.filter)
            .subscribe(result => {
                    this.searchPage=result;
                    this.isLoading=false;
                },
                error=>{
                    console.error("Cannot read Challenge", error);
                })
    }

    setSelectedChallenge(selectedChallenge:Challenge):void{
        this.selectedChallenge=selectedChallenge;
    }

    private initSelectedChallenge():void{
        this.selectedChallenge=new Challenge();
        this.selectedChallenge.name="";
        this.selectedChallenge.description="";
    }

    updateFilterValue(filterValue:string){
        this.filter=filterValue;
    }
}