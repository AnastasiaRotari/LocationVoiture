import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

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

  public checkEmailExists(email: string): Observable<boolean> {
    return this.httpClient.get<boolean>(
      `${LoueurService.URL}/check/email/${email}`
    );
  }
}
