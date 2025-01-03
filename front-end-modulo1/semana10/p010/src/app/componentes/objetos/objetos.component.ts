import { Component, EventEmitter, Input, Output } from '@angular/core';
import { JreaderService } from '../../services/jreader.service';

@Component({
  selector: 'app-objetos',
  templateUrl: './objetos.component.html',
  styleUrl: './objetos.component.css'
})
export class ObjetosComponent {

  listaVeiculos: any;
  constructor(private jreaderServico: JreaderService) { }

  ngOnInit() {
    this.jreaderServico.getCategoria().subscribe(
      categoria => {
        this.listaVeiculos = categoria
      }
    )
  }

  selecionarVeiculo(veiculo: any): void {
    this.jreaderServico.setVeiculo(veiculo);
  }
}