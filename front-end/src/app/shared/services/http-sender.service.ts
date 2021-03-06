import {HttpClient} from "@angular/common/http";
import {catchError, tap} from "rxjs/operators";
import {NotificationsService} from "./notifications.service";
import {NgxSpinnerService} from "ngx-spinner";
import {Observable, of, throwError} from "rxjs";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class HttpSenderService {

  constructor(
    private http: HttpClient,
    private notifications: NotificationsService,
    private spinner: NgxSpinnerService
  ) {
  }

  post(url: string, data: any = undefined): Observable<any> {
    return this.http.post(url, data)
      .pipe(
        tap(data => {
          this.spinner.hide().then();
        }),
        catchError(this.handleError.bind(this))
      )
  }

  get(url: string): Observable<any> {
    return this.http.get(url)
      .pipe(
        tap(data => {
          this.spinner.hide().then();
          return data;
        }),
        catchError(this.handleError.bind(this))
      )
  }

  handleError(err: any) {
    if (err.status == 400){
      err.error.errors.map(e => this.notifications.notifyError(e.defaultMessage));
    } else {
      this.notifications.notifyError(err.error.message);
    }

    this.spinner.hide();
    return throwError(err);
  }

  put(url: string, data: any) {
    return this.http.put(url, data)
      .pipe(
        tap(data => {
          this.spinner.hide().then();
        }),
        catchError(this.handleError.bind(this))
      )
  }

  delete(url: string) {
    return this.http.delete(url)
      .pipe(
        tap(data => {
          this.spinner.hide().then();
        }),
        catchError(this.handleError.bind(this))
      )
  }
}
