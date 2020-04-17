import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class ComplaintService {


  constructor(private httpClient:HttpClient) {}

  public getComplaint():Observable<object>{
    return this.httpClient.get("/api/complaint/message");
  }

  public getComplaints():Observable<object>{
    return this.httpClient.get("/api/complaint/");
  }
  public getComplaintsPage():Observable<object>{
    return this.httpClient.get("/api/complaint/1/2");
  }


}
