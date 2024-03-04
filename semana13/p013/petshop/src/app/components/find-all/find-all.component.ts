import { NgFor, NgIf } from '@angular/common';
import { type_atendimento } from '../../../types/atendimento';
import { CrudService } from './../../services/crud.service';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-find-all',
  standalone: true,
  imports: [NgIf, NgFor, RouterLink],
  templateUrl: './find-all.component.html',
  styleUrl: './find-all.component.css'
})
export class FindAllComponent {

  public atendimentos: type_atendimento[] = [];

  constructor(private crudService: CrudService) { }

  ngOnInit() {
    this.crudService.getAtendimento().subscribe((res) => {
      console.log(res);
      this.atendimentos = res;
    });
  }

}