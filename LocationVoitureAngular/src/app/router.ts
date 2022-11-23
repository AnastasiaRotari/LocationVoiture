import { Routes } from '@angular/router';
import { InscriptionComponent } from './location/component/client/inscription/inscription.component';
import { HomeComponent } from './location/component/home/home.component';
import { InscriptionLoueurComponent } from './location/component/inscription-loueur/inscription-loueur.component';
import { LoginComponent } from './location/component/login/login.component';
import { MenuComponent } from './location/component/menu/menu.component';
import { PageRechercheComponent } from './location/component/page-recherche/page-recherche.component';
import { AdminGuardService } from './location/guard/admin-guard.service';
import { AnonymousGuardService } from './location/guard/anonymous-guard.service';
import { ClientGuardService } from './location/guard/client-guard.service';
import { LoueurGuardService } from './location/guard/loueur-guard.service';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {
    path: 'inscription',
    component: InscriptionComponent,
    canActivate: [AnonymousGuardService],
  },
  {
    path: 'inscriptionloueur',
    component: InscriptionLoueurComponent,
    canActivate: [AnonymousGuardService],
  },
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [AnonymousGuardService],
  },
  {
    path: 'page-recherche',
    component: PageRechercheComponent,
  },

  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
