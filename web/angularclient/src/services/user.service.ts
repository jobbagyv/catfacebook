import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url : string;

  constructor(private http: HttpClient) { 
    this.url = 'http://localhost:8080/api/users/1';
  }

  public getUser() : Observable<User> {
    return this.http.get<User>(this.url);
  }

}
