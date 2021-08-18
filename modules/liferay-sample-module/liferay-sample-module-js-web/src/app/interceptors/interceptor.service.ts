import { Injectable } from '@angular/core';

import {
  HttpEvent,
  HttpInterceptor,
  HttpHandler,
  HttpRequest,
} from '@angular/common/http';

import { Observable } from 'rxjs';

@Injectable()
export class Interceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    req = req.clone({
      params: req.params.set("p_auth", (<any>window).Liferay.authToken)
    });

    return next.handle(req);
  }
}
