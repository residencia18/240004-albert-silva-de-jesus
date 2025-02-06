import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-objetos',
  templateUrl: './objetos.component.html',
  styleUrl: './objetos.component.css'
})
export class ObjetosComponent {
  @Input() categoria: any;
  @Output() veiculoSelecionado = new EventEmitter<any>();

  selecionarVeiculo(veiculo: any): void {
    this.veiculoSelecionado.emit(veiculo);
  }
}