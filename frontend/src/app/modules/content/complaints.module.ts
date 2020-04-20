import {HttpClient, HttpClientModule} from "@angular/common/http";
import {CommonModule} from "@angular/common";
import {NgModule} from "@angular/core";
import {ComplaintsComponent} from "./components/complaints/complaints.component";
import {ComplaintService} from "./services/complaint.service";
import {AppComponent} from "../../app.component";
import {NgbModule, NgbPaginationModule} from "@ng-bootstrap/ng-bootstrap";
import {BrowserModule} from "@angular/platform-browser";

@NgModule({
  declarations: [ComplaintsComponent],
    imports: [HttpClientModule, CommonModule,BrowserModule, NgbModule],
  providers: [ComplaintService],
  exports: [ComplaintsComponent, NgbPaginationModule],
  bootstrap: [AppComponent]
})
export class ComplaintsModule { }
