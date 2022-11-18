import { Routes } from '@angular/router';
import { InscriptionComponent } from './location/component/client/inscription/inscription.component';
import { HomeComponent } from './location/component/home/home.component';
import { LoginComponent } from './location/component/login/login.component';
import { AdminGuardService } from './location/guard/admin-guard.service';
import { AnonymousGuardService } from './location/guard/anonymous-guard.service';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {
    path: 'inscription',
    component: InscriptionComponent,
    canActivate: [AnonymousGuardService],
  },
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [AnonymousGuardService],
  },

  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
