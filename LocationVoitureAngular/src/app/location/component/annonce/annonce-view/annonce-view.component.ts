import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Annonce } from 'src/app/location/model/annonce';
import { AnnonceService } from 'src/app/location/service/annonce.service';

@Component({
  selector: 'app-annonce-view',
  templateUrl: './annonce-view.component.html',
  styleUrls: ['./annonce-view.component.css'],
})
export class AnnonceViewComponent implements OnInit {
  annonce: Annonce = new Annonce();

  constructor(
    private activatedRoute: ActivatedRoute,
    private annonceSrv: AnnonceService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.annonceSrv.findById(params['id']).subscribe((data) => {
          this.annonce = data;
        });
      }
    });
  }
}
