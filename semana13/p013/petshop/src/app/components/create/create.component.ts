import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CrudService } from '../../services/crud.service';

@Component({
  selector: 'app-create',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './create.component.html',
  styleUrl: './create.component.css'
})
export class CreateComponent {

  atendimentoFormulario: FormGroup;

  constructor(private crudService: CrudService) {
    this.atendimentoFormulario = new FormGroup({
      'nome': new FormControl(null, [Validators.required]),
      'cpf': new FormControl(null, [Validators.required]),
      'telefone': new FormControl(null, [Validators.required]),
      'nomePet': new FormControl(null, [Validators.required]),
      'raca': new FormControl(null, [Validators.required]),
      'dataAtendimento': new FormControl(null, [Validators.required]),
    });
  }

  submitForm(formulario: any) {
    console.log(formulario);
    this.crudService.addAtendimento(formulario.value);
  }
}