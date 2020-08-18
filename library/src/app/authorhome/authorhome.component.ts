import { Book } from "./../book";
import { BookService } from "./../service/book.service";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-authorhome",
  templateUrl: "./authorhome.component.html",
  styleUrls: ["./authorhome.component.css"],
})
export class AuthorhomeComponent implements OnInit {
  constructor(private bookService: BookService) {}

  myBooks: Book[];

  name;
  cost;
  add: boolean;
  edit;
  authorId;
  msg;
  ngOnInit() {
    this.refresh();
  }

  showAddBook() {
    this.add = !this.add;
  }

  refresh() {
    this.msg = undefined;
    this.authorId = sessionStorage.getItem("id");

    this.bookService.getBookOfAuthors(this.authorId).subscribe(
      (data) => {
        this.myBooks = data;
      },
      (err) => {
        alert("something went wrong");
      }
    );
  }

  editShow(bookId) {
    this.msg = undefined;
    this.bookService.getBookDetail(bookId).subscribe((data) => {
      if (data != null) {
        (this.name = data.name), (this.cost = data.cost);
      }
    });

    if (this.edit == undefined || this.edit != bookId) this.edit = bookId;
    else this.edit = undefined;
  }

  addBook() {
    this.msg = undefined;
    if (
      this.name != undefined &&
      this.cost != undefined &&
      this.authorId != undefined
    ) {
      this.bookService
        .addBook(this.authorId, this.name, this.cost)
        .subscribe((data) => {
          if (data == null) {
            this.msg = "unable to add book details something went wrong";
          } else {
            this.refresh();
          }
        });
      this.name = undefined;
      this.cost = undefined;
      this.add = false;
    }
  }

  deletebook(bookId) {
    this.bookService.deleteBook(this.authorId, bookId).subscribe(
      (data) => {
        if (data.status == 200) {
          this.refresh();
        } else {
          alert("unable to delete at this moment");
        }
      },
      (err) => {
        alert("something went wrong");
      }
    );
  }

  editBook(bookId) {
    this.bookService
      .editBook(this.authorId, bookId, this.name, this.cost)
      .subscribe(
        (data) => {
          if (data == null) {
            this.msg = "unable to edit book details";
          } else {
            this.refresh();
            this.name = undefined;
            this.cost = undefined;
            this.edit = false;
          }
        },
        (err) => {
          alert("something went wrong");
        }
      );
    this.name = undefined;
    this.cost = undefined;
  }
}
