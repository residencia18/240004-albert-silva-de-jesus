import { Routes } from '@angular/router';
import { CreateComponent } from './components/create/create.component';
import { FindAllComponent } from './components/find-all/find-all.component';
import { UpdateComponent } from './components/update/update.component';

export const routes: Routes = [
  { path: '', component: CreateComponent },
  { path: 'create', component: CreateComponent },
  { path: 'findAll', component: FindAllComponent },
  { path: 'update/:id', component: UpdateComponent },

];