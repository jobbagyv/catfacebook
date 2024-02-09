import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cat } from '../models/cat';

@Injectable({
  providedIn: 'root'
})
export class CatService {

  private url : string;
  constructor(private http: HttpClient) { 
    this.url = 'http://localhost:8080/api/cats';
  }

  public getCats() : Observable<Cat[]>{
    return this.http.get<Cat[]>(this.url);
  }
}
