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

  public getComplaintsPage(page: number, itemsAmount: number):Observable<object>{
    return this.httpClient.get("/api/complaint/page="+(page-1)+"/items="+itemsAmount);
  }


}
