import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClassesComponent } from './componentes/classes/classes.component';
import { ObjetosComponent } from './componentes/objetos/objetos.component';
import { PropriedadesComponent } from './componentes/propriedades/propriedades.component';
import { ValorPropriedadesComponent } from './componentes/valor-propriedades/valor-propriedades.component';

@NgModule({
  declarations: [
    AppComponent,
    ClassesComponent,
    ObjetosComponent,
    PropriedadesComponent,
    ValorPropriedadesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
