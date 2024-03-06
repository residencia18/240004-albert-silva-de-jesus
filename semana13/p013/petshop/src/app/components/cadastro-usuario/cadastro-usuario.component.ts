import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router, RouterLink } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cadastro-usuario',
  standalone: true,
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './cadastro-usuario.component.html',
  styleUrl: './cadastro-usuario.component.css'
})
export class CadastroUsuarioComponent {

  loginFormulario: FormGroup;

  constructor(private auth: AuthService, private router: Router) {
    this.loginFormulario = new FormGroup({
      'email': new FormControl(null, [Validators.required]),
      'senha': new FormControl(null, [Validators.required]),
    });
  }

  submitForm(formulario: any) {
    console.log(formulario);
    this.auth.signupUser(formulario.value.email, formulario.value.senha).subscribe((res) => {
      Swal.fire({
        title: 'Sucesso !',
        icon: 'success',
        showConfirmButton: false,
        timer: 2000

      })
      setTimeout(() => {
        this.router.navigate(['/'])

      }, 2300)
    })
  }
}
