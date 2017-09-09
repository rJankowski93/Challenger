import {Component, OnInit} from "@angular/core";
import {SearchRepository} from "../shared/repository/search.repository";
import {User} from "../shared/models/user.model";
import {Subscription} from "rxjs";
import {MapUtils} from "../shared/services/map.utils";
import {UserService} from "../shared/services/user.service";
import {FilterableInput} from "../filterable-input/filterable-input";
import {GlobalSearchResult} from "../shared/models/globalSearchResult.model";
import {Challenge} from "../shared/models/challenge.model";

@Component({
    moduleId: module.id,
    selector: 'search-input',
    templateUrl: 'search-input.component.html',
    styleUrls: ['search-input.component.css']
})
export class SearchInputComponent implements FilterableInput, OnInit {

    private searchPage: GlobalSearchResult;

    private searchPageUsers: User[];
    private selectedUser: User;
    private usersLongPage: User[];
    private usersListEmpty: boolean = true;

    private searchPageChallenges: Challenge[];
    private selectedChallenge: Challenge;
    private challengesLongPage: Challenge[];
    private challengesListEmpty: boolean = true;


    private filter: string;
    private isVisible: boolean;
    private isLoading: boolean;
    private searchSubscription: Subscription;
    private MINIMUM_FILTER_LENGTH: number = 3;
    private loggedUserFriends: Array<User>;

    constructor(private searchService: SearchRepository, private userService: UserService) {
    }

    ngOnInit(): void {
        this.filter = "recent";
        this.isVisible = false;
        this.isLoading = true;

        this.initSelectedUser();
        this.initSelectedChallenge();
        this.getSearchResults();
        this.getFriendsList();
    }

    ngOnDestroy(): void {
        this.searchSubscription.unsubscribe();
    }

    toggleVisibility() {
        this.isVisible = !this.isVisible;
    }

    setVisibility(isVisible: boolean): void {
        this.isVisible = isVisible;
    }

    getSearchResults() {
        if (this.filter.length < this.MINIMUM_FILTER_LENGTH) {//search only if filter has more than 3 signs
            return;
        }

        this.searchService.searchResult(this.filter, 0, 5)
            .subscribe(result => {

                    this.searchPageUsers = new Array();
                    for (var user of result.users) {
                        this.searchPageUsers.push(user);
                    }

                    this.searchPageChallenges = new Array();
                    for (var challenge of result.challenges) {
                        this.searchPageChallenges.push(challenge);
                    }

                    this.isLoading = false;
                },
                error => {
                    console.log("Cannot read User", error);
                })
    }

    setSelectedUser(selectedUser: User): void {
        this.selectedUser = selectedUser;
    }

    private initSelectedUser(): void {
        this.selectedUser = new User();
        this.selectedUser.firstName = "";
        this.selectedUser.lastName = "";
    }

    updateFilterValue(filterValue: string) {
        this.filter = filterValue;
        this.getSearchResults();
    }

    getMoreUsers(pageNo: number): void {
        this.searchSubscription = this.searchService.searchUser(this.filter, pageNo, 6)
            .subscribe(result => {
                    this.usersLongPage = result;
                    this.usersListEmpty = false;
                },
                error => {
                    console.error("Cannot read Users", error);
                })
    }

    getFriendsList() {
        this.userService.getFriendsForLoggedUser()
            .subscribe(friends => {
                    this.loggedUserFriends = friends;
                },
                error => {
                    console.log("Cannot read friends", error);
                }
            );
    }

    createPageRange(number: number) {
        return MapUtils.createPageRange(number);
    }

    inviteFriend(selectedUserId: number) {
        this.userService.inviteFriend(selectedUserId);
        this.loggedUserFriends = null;
        this.getFriendsList();
    }

    isFriend(selectedUserId) {
        return this.userService.isFriend(this.loggedUserFriends, selectedUserId);
    }

    // Challenge

    setSelectedChallenge(selectedChallenge: Challenge): void {
        this.selectedChallenge = selectedChallenge;
    }

    private initSelectedChallenge(): void {
        this.selectedChallenge = new Challenge();
        this.selectedChallenge.name = "";
        this.selectedChallenge.description = "";
    }

    getMoreChallenges(pageNo: number): void {
        this.searchSubscription = this.searchService.searchChallenge(this.filter, pageNo, 6)
            .subscribe(result => {
                    this.challengesLongPage = result;
                    this.challengesListEmpty = false;
                },
                error => {
                    console.error("Cannot read Challenge", error);
                })
    }

}