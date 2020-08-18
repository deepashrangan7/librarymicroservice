import { AuthenticationService } from "./../service/authentication.service";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"],
})
export class LoginComponent implements OnInit {
  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {}
  Email;
  Password;
  msg;

  ngOnInit() {
    this.msg = undefined;
  }
  login() {
    this.msg = undefined;
    if (this.Email != undefined && this.Password != undefined) {
      this.authService.login(this.Email, this.Password).subscribe(
        (data) => {
          if (data == null) {
            this.msg = "email and password doesnt match";
          } else {
            this.router.navigateByUrl("/home");
          }
        },
        (error) => {
          alert("something went wrong");
        }
      );
    } else {
      this.msg = "enter proper email and password";
    }
  }
}
