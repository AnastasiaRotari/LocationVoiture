import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/location/model/client';
import { ClientService } from 'src/app/location/service/client.service';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css'],
})
export class ClientListComponent implements OnInit {
  clients: Client[] = [];

  constructor(private clientService: ClientService) {}

  ngOnInit(): void {
    this.initClient();
  }

  initClient() {
    this.clientService.findAll().subscribe((data) => {
      this.clients = data;
    });
  }

  delete(id: number) {
    this.clientService.deleteById(id).subscribe(() => {
      this.initClient();
    });
  }
}
