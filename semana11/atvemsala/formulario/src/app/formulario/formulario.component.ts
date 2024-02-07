import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css'
})
export class FormularioComponent {

  exemploForm: FormGroup;

  constructor() {
    this.exemploForm = new FormGroup({
      'login': new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(10)]),
      'senha': new FormControl(null, Validators.required),
    });
  }

  onSubmit() {
    console.log(this.exemploForm);
    console.log(this.exemploForm.value);
  }
}
