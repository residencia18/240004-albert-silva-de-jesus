import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, ValidationErrors, Validators } from '@angular/forms';

@Component({
  selector: 'app-formadicionar',
  standalone: true,
  imports: [ReactiveFormsModule, NgIf],
  templateUrl: './formadicionar.component.html',
  styleUrl: './formadicionar.component.css'
})
export class FormadicionarComponent {

  carroFormulario: FormGroup;

  constructor() {
    this.carroFormulario = new FormGroup({
      'modelo': new FormControl(null, [Validators.required, Validators.maxLength(10), Validators.pattern(/^\S{1,12}$/)]),
      'marca': new FormControl(null, [Validators.required, Validators.maxLength(50)]),
      'ano': new FormControl(null, [Validators.required, Validators.minLength(4)]),
      'valor': new FormControl(null, [Validators.required, Validators.pattern(/^\(\d{2}\)\d{5}-\d{4}$/)]),
      'cor': new FormControl(null, [Validators.required]),
      // 'foto': new FormControl(this.foto),
    });
  }

  public adicionarCarro() {
    console.log('Adicionando carro');
  }

  validarNomeCompleto(control: FormControl): ValidationErrors | null {

    const value = control.value;
    if (value && value.trim().split(' ').length < 2) {
      return { 'nomeInvalido': true };
    }
    return null;
  }

  enviaFormulario() {
    const veiculoJson = {
      modelo: this.carroFormulario.get('modelo')?.value,
      marca: this.carroFormulario.get('marca')?.value,
      ano: this.carroFormulario.get('ano')?.value,
      valor: this.carroFormulario.get('valor')?.value,
    }
    console.log("dados do veiculo", veiculoJson)
  }
}