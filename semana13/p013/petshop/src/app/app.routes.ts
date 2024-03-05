import { Routes } from '@angular/router';
import { CreateComponent } from './components/create/create.component';
import { FindAllComponent } from './components/find-all/find-all.component';
import { UpdateComponent } from './components/update/update.component';
import { AuthComponent } from './auth/auth/auth.component';

export const routes: Routes = [
  { path: 'autentica', component: AuthComponent },
  { path: 'create', component: CreateComponent },
  { path: 'findAll', component: FindAllComponent },
  { path: 'update/:id', component: UpdateComponent },

];