import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Sample, ISample} from "../model/sample";

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

  getSample(id: number): Observable<Sample> {
    return this._httpClient.get<Sample>(
      `/o/sample-module/samples/${id}`,
      {
        params: {
          "p_auth": Liferay.authToken
        }
      });
  }

  createSample(name:string): Observable<Sample> {
    return this._httpClient.post<Sample>(
      `/o/sample-module/samples`,
      {
        name
      },
      {
        params: {
          "p_auth": Liferay.authToken
        },
      });
  }

  updateSample(sample:ISample): Observable<void>{
    return this._httpClient.put<void>(
      `/o/sample-module/samples/${sample.id}`,
      sample,
      {
        params: {
          "p_auth": Liferay.authToken
        },
      }
    );
  }

  deleteSample(id: number): Observable<void>{
    return this._httpClient.delete<void>(`/o/sample-module/samples/${id}`);
  }
}
