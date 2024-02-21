import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, ReactiveFormsModule, ValidationErrors, Validators } from '@angular/forms';

@Component({
  selector: 'app-formusuario',
  standalone: true,
  imports: [ReactiveFormsModule, NgIf],
  templateUrl: './formusuario.component.html',
  styleUrl: './formusuario.component.css'
})
export class FormusuarioComponent {

  usuarioFormulario: FormGroup;

  constructor() {
    this.usuarioFormulario = new FormGroup({
      'nome': new FormControl(null, [Validators.required, Validators.maxLength(10), Validators.pattern(/^\S{1,12}$/)]),
      'nomeCompleto': new FormControl(null, [Validators.required, Validators.maxLength(50), this.validarNomeCompleto.bind(this)]),
      'email': new FormControl(null, [Validators.required, Validators.email, Validators.minLength(10)]),
      'senha': new FormControl(null, [Validators.required, Validators.minLength(4), Validators.pattern(/^(?=.*[A-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{4,}$/)]),
      'telefone': new FormControl(null, [Validators.required, Validators.pattern(/^\(\d{2}\)\d{5}-\d{4}$/)]),
      'endereco': new FormControl(null, [Validators.required, this.validarNomeCompleto.bind(this)]),
      'dataAniversario': new FormControl(null, [Validators.required, this.validarData.bind(this)]),
      'sexo': new FormControl(null, [Validators.required]),
      'profissao': new FormControl(null, [Validators.required]),
    });
  }

  validarNomeCompleto(control: FormControl): ValidationErrors | null {

    const value = control.value;
    if (value && value.trim().split(' ').length < 2) {
      return { 'nomeInvalido': true };
    }
    return null;
  }

  validarData(control: AbstractControl) {

    const birthdate = new Date(control.value);
    const currentDate = new Date();
    const minAge = 18;

    if (!birthdate || isNaN(birthdate.getTime())) {
      return { dataInvalida: true };
    }

    let age = currentDate.getFullYear() - birthdate.getFullYear();
    const monthDiff = currentDate.getMonth() - birthdate.getMonth();

    if (monthDiff < 0 || (monthDiff === 0 && currentDate.getDate() < birthdate.getDate())) {
      age--;
    }

    if (age < minAge) {
      return { minAge: true };
    }

    return null;
  }

  enviaFormulario() {
    const usuarioJson={
      nome: this.usuarioFormulario.get('nome')?.value,
      nomeCompleto: this.usuarioFormulario.get('nomeCompleto')?.value,
      email: this.usuarioFormulario.get('email')?.value,
      senha: this.usuarioFormulario.get('senha')?.value,
      telefone: this.usuarioFormulario.get('telefone')?.value,
      endereco: this.usuarioFormulario.get('endereco')?.value,
      dataAniversario: this.usuarioFormulario.get('dataAniversario')?.value,
      sexo: this.usuarioFormulario.get('sexo')?.value,
      profissao: this.usuarioFormulario.get('profissao')?.value
    }
    console.log("dados do usuario",usuarioJson)
  }
}
