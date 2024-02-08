import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { Observable } from 'rxjs';
import { OAuthService } from 'angular-oauth2-oidc';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url : string;

  constructor(private http: HttpClient, private oauthService: OAuthService) { 
    this.url = 'http://localhost:8080/api/users/1';
  }

  public getUser() : Observable<User> {
    return this.http.get<User>(this.url, {
      headers: {
        'Authorization': this.oauthService.authorizationHeader()
      }
    });
  }

}
