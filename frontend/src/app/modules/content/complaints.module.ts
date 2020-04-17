import {HttpClient, HttpClientModule} from "@angular/common/http";
import {CommonModule} from "@angular/common";
import {NgModule} from "@angular/core";
import {ComplaintsComponent} from "./components/complaints/complaints.component";
import {ComplaintService} from "./services/complaint.service";
import {AppComponent} from "../../app.component";

@NgModule({
  declarations: [ComplaintsComponent
  ],
  imports: [HttpClientModule, CommonModule],
  providers: [ComplaintService],
  exports: [ComplaintsComponent],
  bootstrap: [AppComponent]
})
export class ComplaintsModule { }
