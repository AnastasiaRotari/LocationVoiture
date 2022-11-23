import { Component, OnInit } from '@angular/core';
import { Modele } from 'src/app/location/model/modele';
import { ModeleService } from 'src/app/location/service/modele.service';

@Component({
  selector: 'app-modele-list',
  templateUrl: './modele-list.component.html',
  styleUrls: ['./modele-list.component.css']
})
export class ModeleListComponent implements OnInit {
  modeles: Modele[] = [];


  constructor(private modeleService: ModeleService) {}

  ngOnInit(): void {
    this.initModele();
  }

  initModele() {
    this.modeleService.findAll().subscribe((data) => {
      this.modeles = data;
    });
  }

  delete(id: number) {
    this.modeleService.deleteById(id).subscribe(() => {
      this.initModele();
    });
  }
}
