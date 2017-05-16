import {Role} from "./role.model";

export class User {

    id: number;
    login: string;
    firstName:String;
    lastName:String;
    email: string;
    roles: Array<Role>;
    // points:number;
    enabled: boolean;

    constructor(){}
}