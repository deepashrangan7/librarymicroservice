import { AuthenticationService } from "./../service/authentication.service";
import { AuthorService } from "./../service/author.service";
import { Injectable } from "@angular/core";
import {
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  CanActivate,
  Router,
} from "@angular/router";

@Injectable({
  providedIn: "root",
})
export class AuthGuard implements CanActivate {
  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {}
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (!this.authService.getLoginStatus()) {
      this.router.navigateByUrl("/");
      return false;
    }
    return true;
  }
}
