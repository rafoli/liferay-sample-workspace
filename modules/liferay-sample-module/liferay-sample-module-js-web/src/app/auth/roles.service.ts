import { Injectable } from '@angular/core'

@Injectable({
  providedIn: 'root',
})
export class RoleService {
  constructor() {}

  public isAdmin() {
    return (<any>window).SampleWorkspace.isAdmin;
  }

  public isUser() {
    return (<any>window).SampleWorkspace.isUser;
  }

  public isSignedIn() {
    return (<any>window).Liferay.ThemeDisplay.isSignedIn();
  }
}
