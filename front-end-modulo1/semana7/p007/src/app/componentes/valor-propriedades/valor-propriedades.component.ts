import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-valor-propriedades',
  templateUrl: './valor-propriedades.component.html',
  styleUrl: './valor-propriedades.component.css'
})
export class ValorPropriedadesComponent {

  @Input() propriedade: string = '';
}
