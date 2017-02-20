import {Role} from "./role.model";

export class User {

    id: number;
    login: string;
    email: string;
    firstName:String;
    lastName:String;
    role: Role;
    enabled: boolean;

    constructor(id: number, login: string, email: string, firstName: String, lastName: String, role: Role, enabled?: boolean) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.enabled = enabled || true;
    }
}