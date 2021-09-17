import { Injectable } from '@angular/core'

declare const Liferay:any;
declare const SampleWorkspace: any;

@Injectable({
  providedIn: 'root',
})
export class RoleService {
  constructor() {}

  public isAdmin() {
    return SampleWorkspace.isAdmin;
  }

  public isUser() {
    return SampleWorkspace.isUser;
  }

  public isSignedIn() {
    return Liferay.ThemeDisplay.isSignedIn();
  }
}
