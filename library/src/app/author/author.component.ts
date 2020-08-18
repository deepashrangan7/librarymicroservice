import { AuthorService } from "./../service/author.service";
import { Component, OnInit } from "@angular/core";
import { Author } from "../author";

@Component({
  selector: "app-author",
  templateUrl: "./author.component.html",
  styleUrls: ["./author.component.css"],
})
export class AuthorComponent implements OnInit {
  constructor(private authorService: AuthorService) {}
  allAuthors: Author[] = [];
  showId;
  ngOnInit() {
    this.authorService.getAllAuthors().subscribe(
      (data) => {
        if (data != null) this.allAuthors = data;
      },
      (err) => {
        alert("something  went wrong;");
      }
    );
  }

  show(id) {
    if (this.showId == undefined || this.showId != id) this.showId = id;
    else this.showId = undefined;
  }
}
