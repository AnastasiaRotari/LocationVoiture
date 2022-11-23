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

  public checkEmailExists(email: string): Observable<boolean> {
    return this.httpClient.get<boolean>(
      `${ClientService.URL}/check/email/${email}`
    );
  }
  public findAll(): Observable<Client[]> {
    return this.httpClient.get<Client[]>(ClientService.URL);
  }
  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${ClientService.URL}/${id}`);
  }

  public findById(id: number): Observable<Client> {
    return this.httpClient.get<Client>(`${ClientService.URL}/${id}`);
  }

  public update(client: Client): Observable<Client> {
    console.debug(client);
    return this.httpClient.put<Client>(
      `${ClientService.URL}/${client.id}`,
      this.clientToJson(client)
    );
  }

  public create(client: Client): Observable<Client> {
    console.debug(client);
    return this.httpClient.post<Client>(
      ClientService.URL,
      this.clientToJson(client)
    );
  }

  public clientToJson(client: Client): any {
    let clientJson = {
      prenom: client.prenom,
      nom: client.nom,
      email: client.email,
      age: client.age,
      anneePermis: client.anneePermis,
      accident: client.accident,
    };
    if (client.adresse) {
      Object.assign(clientJson, {
        adresse: {
          numero: client.adresse.numero,
          voie: client.adresse.voie,
          ville: client.adresse.ville,
          cp: client.adresse.cp,
        },
      });
    }
    if (client.id) {
      Object.assign(clientJson, { id: client.id });
    }
    return clientJson;
  }
}
