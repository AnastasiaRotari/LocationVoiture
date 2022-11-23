
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Modele } from 'src/app/location/model/modele';
import { ModeleService } from 'src/app/location/service/modele.service';

@Component({
  selector: 'app-modele-edit',
  templateUrl: './modele-edit.component.html',
  styleUrls: ['./modele-edit.component.css'],
})
export class ModeleEditComponent implements OnInit {
  modele: Modele = new Modele();

  constructor(
    private activatedRoute: ActivatedRoute,
    private modeleService: ModeleService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.modeleService.findById(params['id']).subscribe((data) => {
          this.modele = data;
        });
      }
    });


  }

  save() {
    if (this.modele.id) {
      this.modeleService.update(this.modele).subscribe((data) => {
        this.router.navigateByUrl('/modele');
      });
    } else {
      this.modeleService.create(this.modele).subscribe((data) => {
        this.router.navigateByUrl('/modele');
      });
    }
  }

}
