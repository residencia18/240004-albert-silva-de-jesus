import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AraraComponent } from './arara/arara.component';
import { TigreComponent } from './tigre/tigre.component';

@NgModule({
  declarations: [
    AppComponent,
    AraraComponent,
    TigreComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
