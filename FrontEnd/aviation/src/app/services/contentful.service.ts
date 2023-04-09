import { Injectable } from '@angular/core';
import { createClient, Entry } from 'contentful'
import { from, Observable, retry } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContentfulService {

  constructor() { }

  private client = createClient({
    space: 'qrg6ag1an3c3',
    accessToken: '718SlxuWpti1_CBPmm8cbRNm4Yvf6Lvvw99bNcIim3I'
  });

  getAllEntries() {
    const promise = this.client.getEntries();
    return from(promise);
  }

  getEntryById(id: string) {
    const promise = this.client.getEntry(id);
    return from(promise)
  }
}
