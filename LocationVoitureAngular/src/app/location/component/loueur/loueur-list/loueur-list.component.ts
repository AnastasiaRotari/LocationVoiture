import { Component, OnInit } from '@angular/core';
import { Loueur } from 'src/app/location/model/loueur';
import { LoueurService } from 'src/app/location/service/loueur.service';

@Component({
  selector: 'app-loueur-list',
  templateUrl: './loueur-list.component.html',
  styleUrls: ['./loueur-list.component.css'],
})
export class LoueurListComponent implements OnInit {
  loueurs: Loueur[] = [];

  constructor(private loueurService: LoueurService) {}

  ngOnInit(): void {
    this.initLoueur();
  }

  initLoueur() {
    this.loueurService.findAll().subscribe((data) => {
      this.loueurs = data;
    });
  }

  delete(id: number) {
    this.loueurService.deleteById(id).subscribe(() => {
      this.initLoueur();
    });
  }
}
