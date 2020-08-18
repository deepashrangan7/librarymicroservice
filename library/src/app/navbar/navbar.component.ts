import { AuthenticationService } from "./../service/authentication.service";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

@Component({
  selector: "app-navbar",
  templateUrl: "./navbar.component.html",
  styleUrls: ["./navbar.component.css"],
})
export class NavbarComponent implements OnInit {
  constructor(
    public authService: AuthenticationService,
    private router: Router
  ) {}
  searchType: string = "author";
  ngOnInit() {}

  submit() {
    console.log(this.searchType);
  }

  logout() {
    this.authService.logout();
    this.router.navigateByUrl("/");
  }
}
