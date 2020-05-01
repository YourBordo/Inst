import {Component, OnInit} from "@angular/core";
import {Subject} from "rxjs";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']

})
export class AppMenuComponent implements OnInit{

  public test: Subject<string> = new Subject<string>();
  public test2: Subject<string> = new Subject<string>();

  ngOnInit(): void {
    this.test.subscribe(value => console.log("test"));
    this.test2.subscribe(value => console.log("test2"));

  }

}
