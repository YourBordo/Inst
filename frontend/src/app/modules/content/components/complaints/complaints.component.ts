import {Component, OnInit} from "@angular/core";
import {Complaint} from "../../../models/complaint";
import {ComplaintService} from "../../services/complaint.service";

@Component({
  selector: 'complaints',
  templateUrl: './complaints.component.html',
  styleUrls: ['./complaints.component.css']

})
export class ComplaintsComponent implements OnInit{

  public complaint: Complaint;
  public complaints: Complaint[];
  constructor(private complaintService:ComplaintService) {}

  public ngOnInit(): void {

    this.complaintService.getComplaint().subscribe((response:Complaint) =>{
        this.complaint = response;
      }
    );
    /*this.complaintService.getComplaints().subscribe((response:Complaint[]) =>{
        this.complaints = response;
      }
    );*/

    this.complaintService.getComplaintsPage().subscribe((response:Complaint[]) =>{
        this.complaints = response;
      }
    );

  }
}
