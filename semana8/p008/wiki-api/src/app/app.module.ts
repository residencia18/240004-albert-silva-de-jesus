import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BuscaConteinerComponent } from './componetes/busca-conteiner/busca-conteiner.component';
import { ResultadoContainerComponent } from './componetes/resultado-container/resultado-container.component';

@NgModule({
  declarations: [
    AppComponent,
    BuscaConteinerComponent,
    ResultadoContainerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
