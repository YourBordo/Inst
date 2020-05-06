import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable()
export class CommentService {

  constructor(private httpClient:HttpClient) {}

  public getPostComments(id: number):Observable<object>{
    return this.httpClient.get("/api/comment/post="+id);
  }


}
