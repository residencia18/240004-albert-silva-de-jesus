import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CrudService } from '../../services/crud.service';

@Component({
  selector: 'app-update',
  standalone: true,
  imports: [],
  templateUrl: './update.component.html',
  styleUrl: './update.component.css'
})
export class UpdateComponent {

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
