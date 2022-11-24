import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Loueur } from 'src/app/location/model/loueur';
import { LoueurService } from 'src/app/location/service/loueur.service';

@Component({
  selector: 'app-loueur-edit',
  templateUrl: './loueur-edit.component.html',
  styleUrls: ['./loueur-edit.component.css'],
})
export class LoueurEditComponent implements OnInit {
  loueur: Loueur = new Loueur();

  constructor(
    private activatedRoute: ActivatedRoute,
    private loueurSrv: LoueurService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.loueurSrv.findById(params['id']).subscribe((data) => {
          this.loueur = data;
        });
      }
    });
  }

  save() {
    if (this.loueur.id) {
      this.loueurSrv
        .update(this.loueur)
        .subscribe((data) => this.router.navigateByUrl('/loueur'));
    } else {
      this.loueurSrv.create(this.loueur).subscribe((data) => {
        this.router.navigateByUrl('/loueur');
      });
    }
  }
}
