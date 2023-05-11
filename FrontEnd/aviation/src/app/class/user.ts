import { Role } from "./role";

export class User {
    email!: string;
    password!: string;
    cpassword!: string;
    role!: Role;
}
