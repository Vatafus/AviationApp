import { Injectable } from '@angular/core';

const TOKEN = "I_token";
const USERID = "I_user";
const USERROLE = "I_role"

@Injectable({
  providedIn: 'root'
})
export class StorageServiceService {

  constructor() { }

  saveUserId(userId: any) {
    window.localStorage.removeItem(USERID);
    window.localStorage.setItem(USERID, userId);
  }

  public getUserId(): any {
    return JSON.parse(localStorage.getItem(USERID));
  }


  saveUserRole(role: any) {
    window.localStorage.removeItem(USERROLE);
    window.localStorage.setItem(USERROLE, role);
  }

  public getUserRole(): string {
    const user = this.getUserId();
    if (user == null) { return ''; }
    return user.role;
  }


  saveToken(token: any) {
    window.localStorage.removeItem(TOKEN);
    window.localStorage.setItem(TOKEN, token);
  }

  public hasToken(): boolean {
    if (this.getToken() === null) {
      return false;
    }
    return true;
  }


  public getToken(): string {
    return localStorage.getItem(TOKEN);
  }

  signOut(): void {
    window.localStorage.removeItem(TOKEN);
    window.localStorage.removeItem(USERID);
  }

  public isUserLoggedIn(): boolean {
    if (this.getToken() === null) {
      return false;
    }
    const role: string = this.getUserRole();
    return role == 'USER';
  }
}
