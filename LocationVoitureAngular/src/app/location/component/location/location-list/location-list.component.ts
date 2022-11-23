import { Component, OnInit } from '@angular/core';
import { LocationService } from 'src/app/location/service/location.service';
import { Location } from './../../../model/location';

@Component({
  selector: 'app-location-list',
  templateUrl: './location-list.component.html',
  styleUrls: ['./location-list.component.css'],
})
export class LocationListComponent implements OnInit {
  locations: Location[] = [];

  constructor(private locationService: LocationService) {}

  ngOnInit(): void {
    this.initLocation();
  }

  initLocation() {
    this.locationService.findAll().subscribe((data) => {
      this.locations = data;
    });
  }

  delete(id: number) {
    this.locationService.deleteById(id).subscribe(() => {
      this.initLocation();
    });
  }
}
