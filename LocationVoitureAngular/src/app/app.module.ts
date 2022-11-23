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
import { ClientListComponent } from './location/component/client-list/client-list/client-list.component';
import { ClientEditComponent } from './location/component/client-edit/client-edit/client-edit.component';

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
    ClientListComponent,
    ClientEditComponent,
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
