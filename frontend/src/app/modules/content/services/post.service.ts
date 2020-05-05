import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Post} from "../../models/post";

@Injectable()
export class PostService {

  constructor(private httpClient: HttpClient) {}

  public getWallPosts(id: number):Observable<object>{
    return this.httpClient.get("/api/post/wall/"+id);
  }
  public getUserPosts(id: number):Observable<object>{
    return this.httpClient.get("/api/post/user="+id);
  }



}
