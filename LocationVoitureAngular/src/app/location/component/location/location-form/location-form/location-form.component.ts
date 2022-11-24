import { Component, OnInit } from '@angular/core';
import { Location } from 'src/app/location/model/location';
@Component({
  selector: 'app-location-form',
  templateUrl: './location-form.component.html',
  styleUrls: ['./location-form.component.css'],
})
export class LocationFormComponent implements OnInit {
  location: Location = new Location();
  constructor() {}

  ngOnInit(): void {}

  valider() {}
}
