import { Component } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-formulario-reativo',
  templateUrl: './formulario-reativo.component.html',
  styleUrl: './formulario-reativo.component.css'
})
export class FormularioReativoComponent {

  exemploForm: FormGroup;
  status = ['Não instalada:', 'Instalada:', 'Operante:'];
  y: number = 0;

  constructor() {
    this.exemploForm = new FormGroup({
      'nome': new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(10)]),
      'email': new FormControl(null, [Validators.required, Validators.email]),
      'localizacao': new FormControl(null, Validators.required),
      'logEstaca': new FormArray([])
    });
  }

  onSubmit() {
    console.log(this.exemploForm);
    console.log(this.exemploForm.value);
  }

  addLogStatus() {
    const Nao_instalada = new FormControl(null);
    const instalada = new FormControl(null);
    const operante = new FormControl(null);
    (<FormArray>this.exemploForm.get('logEstacao')).push(Nao_instalada);
    (<FormArray>this.exemploForm.get('logEstacao')).push(instalada);
    (<FormArray>this.exemploForm.get('logEstacao')).push(operante);
  }

  getControls() {
    return (<FormArray>this.exemploForm.get('logEstacao')).controls;
  }

  incY() {
    this.y++;
    if (this.y > 2) {
      this.y = 0;
    }
  }
}
