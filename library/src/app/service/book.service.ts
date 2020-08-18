import { backendURLForLibrary } from "./../backendurl";
import { Book } from "./../book";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: "root",
})
export class BookService {
  constructor(private http: HttpClient) {}
  url = backendURLForLibrary + "/library-bookservice/book";

  getBookOfAuthors(authorId) {
    return this.http.get<Book[]>(this.url + "/all/author/" + authorId);
  }

  getBookDetail(bookId) {
    return this.http.get<Book>(this.url + "/view/" + bookId);
  }
  getAllBooks() {
    return this.http.get<Book[]>(this.url + "/all");
  }

  addBook(authorId, name, cost) {
    //add

    let book = new Book();
    book.cost = cost;
    book.name = name;
    return this.http.post<Book>(this.url + "/add/author/" + authorId, book);
  }

  deleteBook(authorId, bookId) {
    return this.http.delete(this.url + "/" + bookId + "/author/" + authorId, {
      observe: "response",
    });
  }

  editBook(authorId, bookId, name, cost) {
    let book = new Book();
    book.bookId = bookId;
    book.cost = cost;
    book.name = name;
    return this.http.put<Book>(
      this.url + "/" + bookId + "/author/" + authorId,
      book
    );

    //edit
  }
}
