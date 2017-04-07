import {Component, Input, OnInit, ViewChild} from "@angular/core";
import {SearchService} from "../services/search.service";

@Component({
    moduleId: module.id,
    selector: 'filterable-input',
    templateUrl: 'filterable-input.component.html',
    styleUrls: ['filterable-input.component.css']
})
export class FilterableInputComponent implements OnInit {

    private searchPage;
    private filter:string;
    private isVisible:boolean;
    private isLoading:boolean;

    constructor(private searchService:SearchService) {
    }

    ngOnInit(): void {
        this.filter="recent";
        this.isVisible=false;
        this.isLoading=true;

        this.getSearchResults();
    }

    toggleVisibility(){
        this.isVisible=!this.isVisible;
    }

    getSearchResults(){
        this.searchService.searchChallenge(this.filter)
            .subscribe(result => {
                    this.searchPage=result;
                    this.isLoading=false;
                },
                error=>{
                    console.log("Cannot read Challange", error);
                })
    }
}