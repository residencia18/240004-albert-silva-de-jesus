import { Routes } from '@angular/router';
import { CreateComponent } from './components/create/create.component';
import { FindAllComponent } from './components/find-all/find-all.component';
import { UpdateComponent } from './components/update/update.component';
import { AngularFireModule } from '@angular/fire/compat';
import { LoginComponent } from './components/login/login.component';
import { CadastroUsuarioComponent } from './components/cadastro-usuario/cadastro-usuario.component';
import { HomeComponent } from './components/home/home.component';


export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'create', component: CreateComponent },
  { path: 'findAll', component: FindAllComponent },
  { path: 'update/:id', component: UpdateComponent },
  { path: 'cadastro', component: CadastroUsuarioComponent},
  { path: 'login', component: LoginComponent },

];