import { Injectable } from '@angular/core';
import {HttpSenderService} from "../shared/services/http-sender.service";

import {Observable} from "rxjs";
import ClientTableModel from "../shared/models/client/client-table.model";
import {ClientDetailsModel} from "../shared/models/client/client-details.model";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(
    private http: HttpSenderService
  ) { }

  getAll(): Observable<ClientTableModel[]> {
    return this.http.get("Client/");
  }

  deleteOneById(id: number) {
    return this.http.delete("Client/" + id);
  }

  getOneById(id: number): Observable<ClientDetailsModel[]> {
    return this.http.get("Client/" + id);
  }
}
