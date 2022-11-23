import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Loueur } from '../model/loueur';

@Injectable({
  providedIn: 'root',
})
export class LoueurService {
  static URL: string = 'http://localhost:8080/locarnaque/api/loueur';

  constructor(private httpClient: HttpClient) {}

  public inscription(loueur: any): Observable<Loueur> {
    return this.httpClient.post<Loueur>(
      `${LoueurService.URL}/inscription`,
      loueur
    );
  }

  public findAll(): Observable<Loueur[]> {
    return this.httpClient.get<Loueur[]>(`${LoueurService.URL}`);
  }

  public checkEmailExists(email: string): Observable<boolean> {
    return this.httpClient.get<boolean>(
      `${LoueurService.URL}/check/email/${email}`
    );
  }
  public loueurToJson(loueur: Loueur): any {
    let loueurJson = {
      prenom: loueur.prenom,
      nom: loueur.nom,
      email: loueur.email,
    };
    if (loueur.adresse) {
      Object.assign(loueurJson, {
        adresse: {
          numero: loueur.adresse.numero,
          voie: loueur.adresse.voie,
          ville: loueur.adresse.ville,
          cp: loueur.adresse.cp,
        },
      });
    }
    if (loueur.id) {
      Object.assign(loueurJson, { id: loueur.id });
    }
    return loueurJson;
  }
}
