import { Injectable } from '@angular/core'
import { Router, CanActivate } from '@angular/router'
import { RoleService } from './roles.service'

@Injectable()
export class RoleSignedService implements CanActivate {

  constructor(
    public roles: RoleService,
    public router: Router
  ) {}

  canActivate(): boolean {
    if (!this.roles.isUser() || !this.roles.isSignedIn()) {
      this.router.navigate([''])
      return false
    }

    return true;
  }
}
