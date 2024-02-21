import { Component } from '@angular/core';
import { FormControl, FormGroup, ValidationErrors, Validators } from '@angular/forms';

@Component({
  selector: 'app-formadicionar',
  standalone: true,
  imports: [],
  templateUrl: './formadicionar.component.html',
  styleUrl: './formadicionar.component.css'
})
export class FormadicionarComponent {

  carroFormulario: FormGroup;

  private modelo: string = "Fusca";
  private marca: string = "Volkswagen";
  private ano: number = 1970;
  private valor: number = 10000;
  private cor: string = "Azul";
  private foto: string = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.automaistv.com.br%2Fconheca-o-vw-fusca-moderno-que-custa-mais-que-uma-ferrari%2F&psig=AOvVaw0MoRAkmDld2LHJo9YIucHU&ust=1708625885850000&source=images&cd=vfe&opi=89978449&ved=0CBAQjRxqFwoTCLjH_8-FvYQDFQAAAAAdAAAAABAD";

  constructor() {
    this.carroFormulario = new FormGroup({
      'modelo': new FormControl(null, [Validators.required, Validators.maxLength(10), Validators.pattern(/^\S{1,12}$/)]),
      'marca': new FormControl(null, [Validators.required, Validators.maxLength(50)]),
      'ano': new FormControl(null, [Validators.required, Validators.minLength(4)]),
      'valor': new FormControl(null, [Validators.required, Validators.pattern(/^\(\d{2}\)\d{5}-\d{4}$/)]),
      'cor': new FormControl(null, [Validators.required]),
      'foto': new FormControl(this.foto),
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
}