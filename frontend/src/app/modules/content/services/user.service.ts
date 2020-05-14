import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../../models/user";
import {LoginModel} from "../../models/login";

@Injectable()
export class UserService {

  constructor(private httpClient:HttpClient) {}

  public getUser(id: number):Observable<object>{
    return this.httpClient.get("/api/user/" +id);
  }
  public generateToken(login: LoginModel): Observable<AuthToken> {
    return this.httpClient.post<AuthToken>("/api/token/generate-token", login);
  }

  public getAuthorizedUser(): Observable<User> {
    return this.httpClient.get<User>("/api/user/current");
  }

}

export interface AuthToken {
  readonly token: string;
}

