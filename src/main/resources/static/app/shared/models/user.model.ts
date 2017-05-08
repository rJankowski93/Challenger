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

    constructor(id: number, login: string, email: string, firstName: String, lastName: String, roles: Array<Role>//, points:number
        , enabled?: boolean) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
        // this.points=points;
        this.enabled = enabled || true;
    }
}