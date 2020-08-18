import { backendURLForLibrary } from "./../backendurl";
import { map } from "rxjs/operators";
import { Injectable } from "@angular/core";
import { Author } from "../author";
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: "root",
})
export class AuthorService {
  private allAuthors: Author[] = [];

  url = backendURLForLibrary + "/library-authorservice/author";
  constructor(private http: HttpClient) {}

  getAllAuthors() {
    return this.http.get<Author[]>(this.url + "/all").pipe(
      map((data: Author[]) => {
        this.allAuthors = data;
        return this.allAuthors;
      })
    );
  }
}
