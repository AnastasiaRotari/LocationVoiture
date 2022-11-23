import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Annonce } from 'src/app/location/model/annonce';
import { Loueur } from 'src/app/location/model/loueur';
import { Modele } from 'src/app/location/model/modele';
import { AnnonceService } from 'src/app/location/service/annonce.service';
import { LoueurService } from 'src/app/location/service/loueur.service';
import { ModeleService } from 'src/app/location/service/modele.service';

@Component({
  selector: 'app-annonce-edit',
  templateUrl: './annonce-edit.component.html',
  styleUrls: ['./annonce-edit.component.css'],
})
export class AnnonceEditComponent implements OnInit {
  annonce: Annonce = new Annonce();
  modele: Modele[] = [];
  loueur: Loueur[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private annonceService: AnnonceService,
    private modeleService: ModeleService,
    private loueurService: LoueurService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.annonceService.findById(params['id']).subscribe((data) => {
          this.annonce = data;
        });
      }
    });

    this.modeleService.findAll().subscribe((data) => {
      this.modele = data;
    });

    this.loueurService.findAll().subscribe((data) => {
      this.loueur = data;
    });
  }

  save() {
    if (this.annonce.id) {
      this.annonceService.update(this.annonce).subscribe((data) => {
        this.router.navigateByUrl('/annonce');
      });
    } else {
      this.annonceService.create(this.annonce).subscribe((data) => {
        this.router.navigateByUrl('/annonce');
      });
    }
  }
}
