import { Compte } from './../../model/compte';
import { Client } from './../../model/client';
import { Router } from '@angular/router';
import { AuthenticationService } from './../../service/authentication.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  email: string = '';
  password: string = '';
  error = false;

  constructor(private authSrv: AuthenticationService, private router: Router) {}

  ngOnInit(): void {}

  send() {
    this.authSrv.authentication(this.email, this.password).subscribe({
      next: (data) => {
        this.error = false;
        sessionStorage.setItem(
          'token',
          'Basic ' + btoa(this.email + ':' + this.password)
        );
        if (data.role == 'ROLE_CLIENT') {
          let client = new Client(
            data.client.id,
            data.client.nom,
            data.client.prenom,
            data.client.adresse ? data.adresse : undefined,
            data.client.naissance,
            new Compte(data.id, data.email)
          );
          sessionStorage.setItem('client', JSON.stringify(client));
          sessionStorage.setItem('role', 'client');
          sessionStorage.setItem('compte', JSON.stringify(data.email));
        } else {
          sessionStorage.setItem('compte', JSON.stringify(data.email));
          sessionStorage.setItem('role', 'admin');
        }
        this.router.navigateByUrl('/home');
      },
      error: (err) => {
        this.error = true;
      },
    });
  }
}
