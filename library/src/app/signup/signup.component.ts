import { AuthenticationService } from "./../service/authentication.service";
import { NavbarComponent } from "./../navbar/navbar.component";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

@Component({
  selector: "app-signup",
  templateUrl: "./signup.component.html",
  styleUrls: ["./signup.component.css"],
})
export class SignupComponent implements OnInit {
  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {}

  name;

  Email;

  Password;

  confirmPassword;

  age;

  msg;
  ngOnInit() {}

  signup() {
    this.msg = undefined;
    if (
      this.Email != undefined &&
      this.name != undefined &&
      this.Password != undefined &&
      this.Password == this.confirmPassword
    )
      this.authService
        .signup(this.name, this.Email, this.Password, this.age)
        .subscribe((data) => {
          if (data != null) {
            if (data.statusCode == 400) {
              this.msg = data.message;
            } else {
              alert("account created succesfully login now");
              this.router.navigateByUrl("/login");
            }
          } else {
            this.msg = "something went wrong";
          }
        });
  }
}
