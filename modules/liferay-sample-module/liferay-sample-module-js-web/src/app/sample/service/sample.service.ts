import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Sample } from '../model/sample';

declare const Liferay: any;

@Injectable({
  providedIn: 'root',
})
export class SampleService {
  constructor(private _httpClient: HttpClient) {}

  url = '/o/sample-module/samples';

  getSamples(): Observable<Sample[]> {
    return this._httpClient.get<Sample[]>(this.url);
  }

  getSample(id: number): Observable<Sample> {
    return this._httpClient.get<Sample>(`${this.url}/${id}`);
  }

  createSample(name: string): Observable<Sample> {
    return this._httpClient.post<Sample>(this.url, {
      name,
    });
  }

  updateSample(sample: Sample): Observable<void> {
    return this._httpClient.put<void>(this.url, sample);
  }

  deleteSample(id: number): Observable<void> {
    return this._httpClient.delete<void>(`${this.url}/${id}`);
  }
}
