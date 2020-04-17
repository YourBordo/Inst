import {NgModule} from "@angular/core";
import {AppComponent} from "../../app.component";
import {AppMenuComponent} from "./components/menu.component";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {MenuService} from "./services/menu.service";
import {CommonModule} from "@angular/common";

@NgModule({
  declarations: [
    AppMenuComponent,
    AppMenuComponent
  ],
  imports: [HttpClientModule, CommonModule],
  providers: [MenuService],
  exports: [AppMenuComponent],
  bootstrap: [AppComponent]
})
export class HeaderModule { }
