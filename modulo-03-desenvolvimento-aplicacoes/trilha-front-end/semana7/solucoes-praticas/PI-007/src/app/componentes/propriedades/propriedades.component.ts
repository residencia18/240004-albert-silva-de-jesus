import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-propriedades',
  templateUrl: './propriedades.component.html',
  styleUrl: './propriedades.component.css'
})
export class PropriedadesComponent {

  @Input() veiculo: any;
  @Output() propriedadeSelecionada = new EventEmitter<any>();

  pegarChaves(): string[] {
    return this.veiculo ? Object.keys(this.veiculo) : [];
  }

  selecionarPropriedade(propriedade: string): void {
    this.propriedadeSelecionada.emit(propriedade);
  }
}
