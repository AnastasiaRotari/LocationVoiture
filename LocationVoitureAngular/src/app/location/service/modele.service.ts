import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Modele } from '../model/modele';

@Injectable({
  providedIn: 'root',
})
export class ModeleService {
  constructor(
    private httpClient: HttpClient
  ) // private fournisseurSrv: FournisseurService
  {}

  public findAll(): Observable<Modele[]> {
    return this.httpClient.get<Modele[]>(
      'http://localhost:8080/locarnaque/api/modele'
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/locarnaque/api/modele/${id}`
    );
  }

  public findById(id: number): Observable<Modele> {
    return this.httpClient.get<Modele>(
      `http://localhost:8080/locarnaque/api/modele/${id}`
    );
  }

  public update(modele: Modele): Observable<Modele> {
    console.debug(modele);
    return this.httpClient.put<Modele>(
      `http://localhost:8080/locarnaque/api/modele/${modele?.id}`,
      modele
    );
  }

  public create(modele: Modele): Observable<Modele> {
    console.debug(modele);
    return this.httpClient.post<Modele>(
      'http://localhost:8080/locarnaque/api/modele',
      this.modeleToJson(modele)
    );
  }

  public modeleToJson(modele: Modele): any {
    let modeleEnJsonPourJava = {
      nom: modele.nom,
      annee: modele.annee,
      categorie: modele.categorie,
    };
    return modeleEnJsonPourJava;
  }
}
