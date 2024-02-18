import { Component, EventEmitter, Input, Output } from '@angular/core';
import { JreaderService } from '../../services/jreader.service';

@Component({
  selector: 'app-propriedades',
  templateUrl: './propriedades.component.html',
  styleUrl: './propriedades.component.css'
})
export class PropriedadesComponent {

  listaPropriedades: string[] = [];
  veiculo: any; 

  constructor(private jreaderSevice: JreaderService) { }

  ngOnInit() {
    this.jreaderSevice.getVeiculo().subscribe(
      data => {
        this.listaPropriedades = Object.keys(data);
        this.veiculo = data;
      }
    );
  }

  selecionarPropriedade(propriedade: string): void {
    this.jreaderSevice.setPropriedade(this.veiculo[propriedade]);
  }
}
