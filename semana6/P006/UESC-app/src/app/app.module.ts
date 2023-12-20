import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NoticiasComponent } from './noticias/noticias.component';
import { DestaqueComponent } from './destaque/destaque.component';
import { ServicoComponent } from './servico/servico.component';
import { ResultadoComponent } from './resultado/resultado.component';
import { MenuComponent } from './menu/menu.component';

@NgModule({
  declarations: [
    AppComponent,
    NoticiasComponent,
    DestaqueComponent,
    ServicoComponent,
    ResultadoComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
