import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import Swal from 'sweetalert2';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  loginFormulario: FormGroup;

  constructor(private auth: AuthService, private router: Router) {
    this.loginFormulario = new FormGroup({
      'email': new FormControl(null, [Validators.required]),
      'senha': new FormControl(null, [Validators.required]),
    });
  }

  submitForm(formulario: any) {
    console.log(formulario);
    this.auth.loginUser(formulario.value.email, formulario.value.senha).subscribe((res) => {
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