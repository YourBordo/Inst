import {Component, OnInit} from "@angular/core";
import {Complaint} from "../../../models/complaint";
import {ComplaintService} from "../../services/complaint.service";
@Component({
  selector: 'complaints',
  templateUrl: './complaints.component.html',
  styleUrls: ['./complaints.component.css']

})

export class ComplaintsComponent implements OnInit{

  public page: number =1 ;
  public itemsAmount: number = 3;
  public complaints: Complaint[];
  public complaintsAmount: number;
  constructor(private complaintService:ComplaintService) {}

  public ngOnInit(): void {

    this.complaintService.getComplaints().subscribe((response:Complaint[]) =>{
        this.complaintsAmount = response.length;
        this.complaints = response;

      }
    );
  }
}
