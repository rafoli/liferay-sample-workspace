import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Sample} from "../model/sample";

declare const Liferay: any;

@Injectable({
  providedIn: 'root'
})
export class SampleService {

  constructor(private _httpClient: HttpClient) { }

  getSamples(): Observable<Sample[]> {
    return this._httpClient.get<Sample[]>(
      '/o/sample-module/samples',
      {
        params: {
          "p_auth": Liferay.authToken
        }
      }
    );
  }
}
