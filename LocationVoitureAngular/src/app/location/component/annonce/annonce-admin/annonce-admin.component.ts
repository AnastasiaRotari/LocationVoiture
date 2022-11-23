import { Component, OnInit } from '@angular/core';
import { Annonce } from 'src/app/location/model/annonce';
import { Loueur } from 'src/app/location/model/loueur';
import { Modele } from 'src/app/location/model/modele';
import { AnnonceService } from 'src/app/location/service/annonce.service';
import { LoueurService } from 'src/app/location/service/loueur.service';
import { ModeleService } from 'src/app/location/service/modele.service';

@Component({
  selector: 'app-annonce-admin',
  templateUrl: './annonce-admin.component.html',
  styleUrls: ['./annonce-admin.component.css'],
})
export class AnnonceAdminComponent implements OnInit {
  annonces: Annonce[] = [];
  modele: Modele[] = [];
  loueur: Loueur[] = [];
  start: string = '';
  etat: string = '';
  plein: string = '';

  constructor(
    private annonceService: AnnonceService,
    private modeleService: ModeleService,
    private loueurService: LoueurService
  ) {}

  ngOnInit(): void {
    this.initAnnonce();
    this.modeleService.findAll().subscribe((data) => {
      this.modele = data;
    });

    this.loueurService.findAll().subscribe((data) => {
      this.loueur = data;
    });
  }

  filterAnnonce() {
    return this.annonces.filter((annonce) => {
      return (
        annonce.agence?.indexOf(this.start) != -1 &&
        annonce.etat?.indexOf(this.etat) != -1 &&
        annonce.plein?.indexOf(this.plein) != -1
      );
    });
  }

  initAnnonce() {
    this.annonceService.findAll().subscribe((data) => {
      this.annonces = data;
    });
  }

  delete(id: number) {
    this.annonceService.deleteById(id).subscribe(() => {
      this.initAnnonce();
    });
  }
}
