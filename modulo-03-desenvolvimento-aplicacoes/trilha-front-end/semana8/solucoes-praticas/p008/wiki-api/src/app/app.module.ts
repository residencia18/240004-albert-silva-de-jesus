import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BuscaConteinerComponent } from './componetes/busca-conteiner/busca-conteiner.component';
import { ResultadoContainerComponent } from './componetes/resultado-container/resultado-container.component';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { BoldTextPipe } from './pipes/bold-text.pipe';

@NgModule({
  declarations: [
    AppComponent,
    BuscaConteinerComponent,
    ResultadoContainerComponent,
    BoldTextPipe
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [HttpClient, HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
