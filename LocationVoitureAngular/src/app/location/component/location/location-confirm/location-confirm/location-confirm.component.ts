import { Component, OnInit } from '@angular/core';
import { Location } from 'src/app/location/model/location';
@Component({
  selector: 'app-location-confirm',
  templateUrl: './location-confirm.component.html',
  styleUrls: ['./location-confirm.component.css'],
})
export class LocationConfirmComponent implements OnInit {
  locations: Location[] = [];
  constructor() {}

  ngOnInit(): void {}
}
