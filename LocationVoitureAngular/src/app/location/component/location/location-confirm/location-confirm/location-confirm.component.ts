import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Annonce } from 'src/app/location/model/annonce';
import { AnnonceService } from 'src/app/location/service/annonce.service';

@Component({
  selector: 'app-location-confirm',
  templateUrl: './location-confirm.component.html',
  styleUrls: ['./location-confirm.component.css'],
})
export class LocationConfirmComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}
}
