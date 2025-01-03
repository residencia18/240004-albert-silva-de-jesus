import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WikipediaComponent } from './componentes/wikipedia/wikipedia.component';
import { UescComponent } from './componentes/uesc/uesc.component';
import { JreaderComponent } from './componentes/jreader/jreader.component';

const routes: Routes = [{ path: 'wikipedia', component: WikipediaComponent }
  , { path: 'uesc', component: UescComponent }
  , { path: 'jreader', component: JreaderComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
  
}
