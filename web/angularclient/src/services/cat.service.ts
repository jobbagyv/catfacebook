import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cat } from '../models/cat';
import { OAuthService } from 'angular-oauth2-oidc';

@Injectable({
  providedIn: 'root'
})
export class CatService {

  private url : string;
  constructor(private http: HttpClient, private oauthService: OAuthService) { 
    this.url = 'http://localhost:8080/api/cats';
  }

  public getCats() : Observable<Cat[]>{
    return this.http.get<Cat[]>(this.url, {
      headers:
      {
        'Authorization': this.oauthService.authorizationHeader()
      }
      });
  }
}
