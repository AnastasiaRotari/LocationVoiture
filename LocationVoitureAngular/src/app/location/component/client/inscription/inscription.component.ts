import { Router } from '@angular/router';
import { ClientService } from './../../../service/client.service';
import { map, Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  form!: FormGroup;

  constructor(private clientService: ClientService, private router: Router) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      numero: new FormControl(),
      voie: new FormControl(),
      cp: new FormControl(),
      ville: new FormControl(),
      age: new FormControl(),
      anneePermis: new FormControl(),
      accident: new FormControl(),
      email: new FormControl(
        '',
        [Validators.required, Validators.email],
        this.emailNotExists()
      ),
      groupeInfo: new FormGroup(
        {
          prenom: new FormControl('', [
            Validators.required,
            Validators.minLength(2),
          ]),
          nom: new FormControl('', Validators.required),
          groupePassword: new FormGroup(
            {
              password: new FormControl(
                '',
                Validators.pattern(
                  /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@*!-_])([a-zA-Z0-9@*!-_]{4,25})$/
                )
              ),
              confirmation: new FormControl(),
            },
            this.passwordAndConfirmatonEquals
          ),
        },
        this.contientPrenomOuNom
      ),
    });
  }

  emailNotExists(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.clientService.checkEmailExists(control.value).pipe(
        map((bool) => {
          return bool ? { emailExists: true } : null;
        })
      );
    };
  }

  passwordAndConfirmatonEquals(
    control: AbstractControl
  ): ValidationErrors | null {
    let password = control.get('password');
    if (password?.invalid) {
      return null;
    }
    return password?.value == control.get('confirmation')?.value
      ? null
      : { passwordAndConfirmationNotEquals: true };
  }

  contientPrenomOuNom(control: AbstractControl): ValidationErrors | null {
    let password = control.get('groupePassword.password');
    return password?.value
      .toString()
      .includes(control.get('prenom')?.value.toString()) ||
      password?.value.toString().includes(control.get('nom')?.value.toString())
      ? { contientPrenomOuNom: true }
      : null;
  }

  save() {
    let client = {
      prenom: this.form.get('groupeInfo.prenom')?.value,
      nom: this.form.get('groupeInfo.nom')?.value,
      age: this.form.get('age')?.value,
      anneePermis: this.form.get('anneePermis')?.value,
      accident: this.form.get('accident')?.value,
      email: this.form.get('email')?.value,
      //compte: {
      password: this.form.get('groupeInfo.groupePassword.password')?.value,
      // },
    };
    if (
      this.form.get('numero')?.value ||
      this.form.get('voie')?.value ||
      this.form.get('cp')?.value ||
      this.form.get('ville')?.value
    ) {
      Object.assign(client, {
        adresse: {
          numero: this.form.get('numero')?.value,
          voie: this.form.get('voie')?.value,
          cp: this.form.get('cp')?.value,
          ville: this.form.get('ville')?.value,
        },
      });
    }
    this.clientService.inscription(client).subscribe((data) => {
      this.router.navigateByUrl('/home');
    });
  }
}
