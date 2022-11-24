import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from 'src/app/location/model/client';
import { ClientService } from 'src/app/location/service/client.service';

@Component({
  selector: 'app-client-edit',
  templateUrl: './client-edit.component.html',
  styleUrls: ['./client-edit.component.css'],
})
export class ClientEditComponent implements OnInit {
  client: Client = new Client();

  constructor(
    private activatedRoute: ActivatedRoute,
    private clientSrv: ClientService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.clientSrv.findById(params['id']).subscribe((data) => {
          this.client = data;
        });
      }
    });
  }

  save() {
    if (this.client.id) {
      this.clientSrv
        .update(this.client)
        .subscribe(() => this.router.navigateByUrl('/client'));
    } else {
      this.clientSrv.create(this.client).subscribe(() => {
        this.router.navigateByUrl('/client');
      });
    }
  }
}
