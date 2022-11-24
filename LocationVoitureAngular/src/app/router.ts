import { Routes } from '@angular/router';
import { AnnonceAdminComponent } from './location/component/annonce/annonce-admin/annonce-admin.component';
import { AnnonceEditComponent } from './location/component/annonce/annonce-edit/annonce-edit.component';
import { AnnonceListComponent } from './location/component/annonce/annonce-list/annonce-list.component';
import { AnnonceViewComponent } from './location/component/annonce/annonce-view/annonce-view.component';
import { ClientListComponent } from './location/component/client/client-list/client-list.component';
import { InscriptionComponent } from './location/component/client/inscription/inscription.component';
import { HomeComponent } from './location/component/home/home.component';
import { InscriptionLoueurComponent } from './location/component/inscription-loueur/inscription-loueur.component';
import { LocationEditComponent } from './location/component/location/location-edit/location-edit.component';
import { LocationListComponent } from './location/component/location/location-list/location-list.component';
import { LoginComponent } from './location/component/login/login.component';
import { LoueurListComponent } from './location/component/loueur/loueur-list/loueur-list.component';
import { MenuComponent } from './location/component/menu/menu.component';
import { ModeleEditComponent } from './location/component/modele/modele-edit/modele-edit.component';
import { ModeleListComponent } from './location/component/modele/modele-list/modele-list.component';
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
  {
    path: 'annonce/edit',
    component: AnnonceEditComponent,
  },
  {
    path: 'annonce/edit/:id',
    component: AnnonceEditComponent,
  },
  {
    path: 'annonce/view/:id',
    component: AnnonceViewComponent,
  },
  {
    path: 'annonce',
    component: AnnonceListComponent,
  },
  {
    path: 'modele/edit',
    component: ModeleEditComponent,
  },
  {
    path: 'modele',
    component: ModeleListComponent,
  },
  {
    path: 'location/edit',
    component: LocationEditComponent,
  },
  {
    path: 'location',
    component: LocationListComponent,
  },
  {
    path: 'annonce-view',
    component: AnnonceViewComponent,
  },
  {
    path: 'annonce-admin',
    component: AnnonceAdminComponent,
  },
  {
    path: 'client',
    component: ClientListComponent,
  },
  {
    path: 'loueur',
    component: LoueurListComponent,
  },

  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
