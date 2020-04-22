import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Post} from "../../models/post";

@Injectable()
export class PostService {

  constructor(private httpClient: HttpClient) {
  }

  postData(post: Post) {
    const body = {text: post.text, photo: post.photo};
    return this.httpClient.post('api/post', body);

  }
}
