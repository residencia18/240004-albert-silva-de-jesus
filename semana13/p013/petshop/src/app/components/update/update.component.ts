import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CrudService } from '../../services/crud.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './update.component.html',
  styleUrl: './update.component.css'
})
export class UpdateComponent {

  atendimentoFormulario: FormGroup;
  id: string = '';

  constructor(private crudService: CrudService, private rotas: Router, private route: ActivatedRoute) {
    this.atendimentoFormulario = new FormGroup({
      'nome': new FormControl(null, [Validators.required]),
      'cpf': new FormControl(null, [Validators.required]),
      'telefone': new FormControl(null, [Validators.required]),
      'nomePet': new FormControl(null, [Validators.required]),
      'raca': new FormControl(null, [Validators.required]),
      'dataAtendimento': new FormControl(null, [Validators.required]),
    });

    this.id = this.route.snapshot.paramMap.get('id')!;
    this.findById(this.id);
  }

  findById(id: any) {
    console.log("id-->" + id);
    this.crudService.getAtendimentoById(id).subscribe(responseData => {
      console.log(responseData);
      this.atendimentoFormulario.setValue(responseData);
    });
  }

  submitForm(formulario: any) {
    console.log(formulario);
    this.crudService.editarAtendimento(this.id, formulario.value);
  }
}