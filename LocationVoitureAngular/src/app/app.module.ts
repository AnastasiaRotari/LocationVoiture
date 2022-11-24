import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MenuComponent } from './location/component/menu/menu.component';
import { LoginComponent } from './location/component/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { routes } from './router';
import { AuthenticationInterceptor } from './location/interceptor/authentication.interceptor';
import { InscriptionComponent } from './location/component/client/inscription/inscription.component';
import { HomeComponent } from './location/component/home/home.component';
import { PageRechercheComponent } from './location/component/page-recherche/page-recherche.component';
import { InscriptionLoueurComponent } from './location/component/inscription-loueur/inscription-loueur.component';
import { AnnonceEditComponent } from './location/component/annonce/annonce-edit/annonce-edit.component';
import { AnnonceListComponent } from './location/component/annonce/annonce-list/annonce-list.component';
import { LocationEditComponent } from './location/component/location/location-edit/location-edit.component';
import { LocationListComponent } from './location/component/location/location-list/location-list.component';
import { ModeleListComponent } from './location/component/modele/modele-list/modele-list.component';
import { ModeleEditComponent } from './location/component/modele/modele-edit/modele-edit.component';
import { AnnonceViewComponent } from './location/component/annonce/annonce-view/annonce-view.component';
import { FooterComponent } from './location/component/footer/footer.component';
import { AnnonceAdminComponent } from './location/component/annonce/annonce-admin/annonce-admin.component';
import { ClientListComponent } from './location/component/client/client-list/client-list.component';
import { LoueurListComponent } from './location/component/loueur/loueur-list/loueur-list.component';
import { LocationFormComponent } from './location/component/location/location-form/location-form/location-form.component';
import { ClientEditComponent } from './location/component/client/client-edit/client-edit.component';
import { LoueurEditComponent } from './location/component/loueur/loueur-edit/loueur-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    LoginComponent,
    InscriptionComponent,
    HomeComponent,
    InscriptionLoueurComponent,
    PageRechercheComponent,
    AnnonceEditComponent,
    AnnonceListComponent,
    LocationEditComponent,
    LocationListComponent,
    ModeleListComponent,
    ModeleEditComponent,
    AnnonceViewComponent,
    FooterComponent,
    AnnonceAdminComponent,
    ClientListComponent,
    LoueurListComponent,
    LoueurEditComponent,
    ClientEditComponent,
    LocationFormComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthenticationInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
