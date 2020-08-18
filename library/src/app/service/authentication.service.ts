import { backendURLForLibrary } from "./../backendurl";
import { Status } from "./../model/status";
import { map } from "rxjs/operators";
import { TokenDetails } from "./../model/token-details";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Author } from "../author";

@Injectable({
  providedIn: "root",
})
export class AuthenticationService {
  constructor(private http: HttpClient) {}

  url: string = backendURLForLibrary + "/library-authentication-service";

  getLoginStatus() {
    if (sessionStorage.getItem("token") != undefined) return true;
    return false;
  }

  login(email, password) {
    // this.http.post();

    let author = new Author();
    author.email = email;
    author.password = password;
    return this.http
      .post<TokenDetails>(this.url + "/authenticate/login", author)
      .pipe(
        map((data: TokenDetails) => {
          if (data != null) {
            sessionStorage.setItem("token", data.token);
            sessionStorage.setItem("id", data.authorId + "");
          }
          return data;
        })
      );
  }

  logout() {
    sessionStorage.clear();
  }

  signup(name, Email, Password, age) {
    let author: Author = new Author();
    author.age = age;
    author.email = Email;
    author.password = Password;
    author.name = name;
    return this.http.post<Status>(this.url + "/authenticate/signup", author);

    //signup
  }
}
