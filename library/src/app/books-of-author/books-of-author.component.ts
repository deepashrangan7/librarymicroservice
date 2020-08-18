import { Book } from "./../book";
import { BookService } from "./../service/book.service";
import { Component, OnInit, Input } from "@angular/core";

@Component({
  selector: "app-books-of-author",
  templateUrl: "./books-of-author.component.html",
  styleUrls: ["./books-of-author.component.css"],
})
export class BooksOfAuthorComponent implements OnInit {
  constructor(private bookService: BookService) {}

  @Input() authorId: number;
  allBooks: Book[];

  ngOnInit() {
    if (this.authorId != undefined)
      this.bookService.getBookOfAuthors(this.authorId).subscribe(
        (data) => {
          this.allBooks = data;
        },
        (err) => {
          alert("something went wrong");
        }
      );
    else {
      this.bookService.getAllBooks().subscribe(
        (data) => {
          this.allBooks = data;
        },
        (err) => {
          alert("something went wrong");
        }
      );
    }
  }
}
