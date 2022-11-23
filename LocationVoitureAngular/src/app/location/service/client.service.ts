import { Client } from './../model/client';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ClientService {
  static URL: string = 'http://localhost:8080/locarnaque/api/client';

  constructor(private httpClient: HttpClient) {}

  public inscription(client: any): Observable<Client> {
    return this.httpClient.post<Client>(
      `${ClientService.URL}/inscription`,
      client
    );
  }

  public findAll(): Observable<Client[]> {
    return this.httpClient.get<Client[]>(`${ClientService.URL}`);
  }

  public checkEmailExists(email: string): Observable<boolean> {
    return this.httpClient.get<boolean>(
      `${ClientService.URL}/check/email/${email}`
    );
  }
}
