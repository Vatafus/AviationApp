import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Sits } from '../class/sits';

@Injectable({
  providedIn: 'root'
})
export class SitsServiceService {

  apiUrl = 'http://localhost:8080/sits';

  constructor(private httpClient: HttpClient) { }

  getSits() {
    return this.httpClient.get<Sits[]>(this.apiUrl);
  }
}
