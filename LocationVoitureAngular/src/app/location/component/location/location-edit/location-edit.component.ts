import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Annonce } from 'src/app/location/model/annonce';
import { Client } from 'src/app/location/model/client';
import { AnnonceService } from 'src/app/location/service/annonce.service';
import { ClientService } from 'src/app/location/service/client.service';
import { LocationService } from 'src/app/location/service/location.service';
import { Location } from './../../../model/location';
@Component({
  selector: 'app-location-edit',
  templateUrl: './location-edit.component.html',
  styleUrls: ['./location-edit.component.css'],
})
export class LocationEditComponent implements OnInit {
  location: Location = new Location();
  annonces: Annonce[] = [];
  clients: Client[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private locationService: LocationService,
    private clientService: ClientService,
    private annonceService: AnnonceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.locationService.findById(params['id']).subscribe((data) => {
          this.location = data;
        });
      }
    });

    this.clientService.findAll().subscribe((data) => {
      this.clients = data;
    });
    this.annonceService.findAll().subscribe((data) => {
      this.annonces = data;
    });
  }

  save() {
    if (this.location.id) {
      this.locationService.update(this.location).subscribe((data) => {
        this.router.navigateByUrl('/location');
      });
    } else {
      this.locationService.create(this.location).subscribe((data) => {
        this.router.navigateByUrl('/location');
      });
    }
  }

  byCId(cl1: Client, cl2: Client) {
    if (cl1 && cl2) return cl1.id == cl2.id;
    return false;
  }
  byAId(a1: Annonce, a2: Annonce) {
    if (a1 && a2) return a1.id == a2.id;
    return false;
  }
}
