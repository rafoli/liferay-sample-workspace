import { Injectable } from '@angular/core'
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router'
import { Observable } from 'rxjs';
import { RoleService } from './roles.service'

@Injectable()
export class RoleAdminService implements CanActivate {

  constructor(
    public roles: RoleService,
    public router: Router
  ) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean|UrlTree>|Promise<boolean|UrlTree>|boolean|UrlTree {
    if (!this.roles.isAdmin()) {
      this.router.navigate([''])
      return false
    }

    return true;
  }
}
