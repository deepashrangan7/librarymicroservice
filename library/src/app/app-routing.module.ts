import { BookComponent } from "./book/book.component";
import { AuthorComponent } from "./author/author.component";
import { ErrorComponent } from "./error/error.component";
import { MainComponent } from "./main/main.component";
import { AuthGuard } from "./guard/auth.guard";
import { AuthorhomeComponent } from "./authorhome/authorhome.component";
import { SignupComponent } from "./signup/signup.component";
import { LoginComponent } from "./login/login.component";
import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

const routes: Routes = [
  {
    path: "",
    component: MainComponent,
  },
  {
    path: "author",
    component: AuthorComponent,
  },
  {
    path: "book",
    component: BookComponent,
  },
  {
    path: "login",
    component: LoginComponent,
  },
  {
    path: "signup",
    component: SignupComponent,
  },
  {
    path: "home",
    component: AuthorhomeComponent,
    canActivate: [AuthGuard],
  },
  {
    path: "**",
    component: ErrorComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
