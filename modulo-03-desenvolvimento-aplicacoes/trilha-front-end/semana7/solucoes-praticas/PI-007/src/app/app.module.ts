import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClassesComponent } from './componentes/classes/classes.component';
import { ObjetosComponent } from './componentes/objetos/objetos.component';
import { PropriedadesComponent } from './componentes/propriedades/propriedades.component';
import { ValorPropriedadesComponent } from './componentes/valor-propriedades/valor-propriedades.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CarinhoComponent } from './componentes/carinho/carinho.component';
import { CategoriaDirective } from './diretivas/categoria.directive';
import { VeiculoDirective } from './diretivas/veiculo.directive';

@NgModule({
  declarations: [
    AppComponent,
    ClassesComponent,
    ObjetosComponent,
    PropriedadesComponent,
    ValorPropriedadesComponent,
    CarinhoComponent,
    CategoriaDirective,
    VeiculoDirective
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [HttpClient, HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
