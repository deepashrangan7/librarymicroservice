import { Intercept } from "./interceptors/intercept";
import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";

import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { NavbarComponent } from "./navbar/navbar.component";
import { LoginComponent } from "./login/login.component";
import { SignupComponent } from "./signup/signup.component";
import { MainComponent } from "./main/main.component";
import { AuthorhomeComponent } from "./authorhome/authorhome.component";
import { ErrorComponent } from "./error/error.component";
import { AuthorComponent } from "./author/author.component";
import { BookComponent } from "./book/book.component";
import { ViewauthorComponent } from "./viewauthor/viewauthor.component";
import { BooksOfAuthorComponent } from "./books-of-author/books-of-author.component";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    SignupComponent,
    MainComponent,
    AuthorhomeComponent,
    ErrorComponent,
    AuthorComponent,
    BookComponent,
    ViewauthorComponent,
    BooksOfAuthorComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: Intercept,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
