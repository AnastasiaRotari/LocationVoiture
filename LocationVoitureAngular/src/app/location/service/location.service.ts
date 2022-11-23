import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AnnonceService } from './annonce.service';
import { ClientService } from './client.service';
import { Location } from '../model/location';

@Injectable({
  providedIn: 'root',
})
export class LocationService {
  constructor(
    private httpClient: HttpClient,
    private clientSrv: ClientService,
    private annonceSrv: AnnonceService
  ) {}

  public findAll(): Observable<Location[]> {
    return this.httpClient.get<Location[]>(
      'http://localhost:8080/locarnaque/api/location'
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/locarnaque/api/location/${id}`
    );
  }

  public findById(id: number): Observable<Location> {
    return this.httpClient.get<Location>(
      `http://localhost:8080/locarnaque/api/location/${id}`
    );
  }

  public update(location: Location): Observable<Location> {
    console.debug(location);
    return this.httpClient.put<Location>(
      `http://localhost:8080/locarnaque/api/location/${location?.id}`,
      location
    );
  }

  public create(location: Location): Observable<Location> {
    console.debug(location);
    return this.httpClient.post<Location>(
      'http://localhost:8080/locarnaque/api/location',
      this.locationToJson(location)
    );
  }

  public locationToJson(location: Location): any {
    let locationEnJsonPourJava = {
      dateDebut: location.dateDebut,
      dateFin: location.dateFin,
      prixTotal: location.prixTotal,
      assurance: location.assurance,
      annonce: this.annonceSrv.annonceToJson(location.annonce!),
      client: this.clientSrv.clientToJson(location.client!),
    };
    return locationEnJsonPourJava;
  }
}
