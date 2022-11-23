import { Component, OnInit } from '@angular/core';
import { Annonce } from 'src/app/location/model/annonce';
import { AnnonceService } from 'src/app/location/service/annonce.service';

@Component({
  selector: 'app-annonce-list',
  templateUrl: './annonce-list.component.html',
  styleUrls: ['./annonce-list.component.css'],
})
export class AnnonceListComponent implements OnInit {
  annonces: Annonce[] = [];

  constructor(private annonceService: AnnonceService) {}

  ngOnInit(): void {
    this.initAnnonce();
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
