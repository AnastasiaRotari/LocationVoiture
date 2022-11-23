import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Annonce } from '../model/annonce';
import { LoueurService } from './loueur.service';
import { ModeleService } from './modele.service';

@Injectable({
  providedIn: 'root',
})
export class AnnonceService {
  constructor(
    private httpClient: HttpClient,
    private modeleSrv: ModeleService,
    private loueurSrv: LoueurService
  ) {}

  public findAll(): Observable<Annonce[]> {
    return this.httpClient.get<Annonce[]>(
      'http://localhost:8080/locarnaque/api/annonce'
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/locarnaque/api/annonce/${id}`
    );
  }

  public findById(id: number): Observable<Annonce> {
    return this.httpClient.get<Annonce>(
      `http://localhost:8080/locarnaque/api/annonce/${id}`
    );
  }

  public update(annonce: Annonce): Observable<Annonce> {
    console.debug(annonce);
    return this.httpClient.put<Annonce>(
      `http://localhost:8080/locarnaque/api/annonce/${annonce?.id}`,
      annonce
    );
  }

  public create(annonce: Annonce): Observable<Annonce> {
    console.debug(annonce);
    return this.httpClient.post<Annonce>(
      'http://localhost:8080/locarnaque/api/annonce',
      this.annonceToJson(annonce)
    );
  }

  public annonceToJson(annonce: Annonce): any {
    let annonceEnJsonPourJava = {
      libelle: annonce.libelle,
      modele: this.modeleSrv.modeleToJson(annonce.modele!),
      loueur: this.loueurSrv.loueurToJson(annonce.loueur!),
      plein: annonce.plein,
      kilometrage: annonce.kilometrage,
      agence: annonce.agence,
      etat: annonce.etat,
      prixJour: annonce.prixJour,
      disponibilite: annonce.disponibilite,
    };
    return annonceEnJsonPourJava;
  }
}
