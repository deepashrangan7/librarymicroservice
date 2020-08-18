import { Component, OnInit, Input } from "@angular/core";
import { Author } from "../author";

@Component({
  selector: "app-viewauthor",
  templateUrl: "./viewauthor.component.html",
  styleUrls: ["./viewauthor.component.css"],
})
export class ViewauthorComponent implements OnInit {
  constructor() {}

  @Input() author: Author;
  ngOnInit() {}
showBookId=undefined
  showBook(id){

    if(id==undefined || id!=this.showBookId){
      this.showBookId=id
    }else
    this.showBookId=undefined
  }
}
