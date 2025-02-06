import { Component, Input } from '@angular/core';
import { JreaderService } from '../../services/jreader.service';

@Component({
  selector: 'app-carinho',
  templateUrl: './carinho.component.html',
  styleUrl: './carinho.component.css'
})
export class CarinhoComponent {
  
  listaVeiculo: string[] = [];

  constructor(private jreaderServico: JreaderService) { }

  ngOnInit() {
    this.jreaderServico.getListVeiculos().subscribe(
      data => {
        !this.listaVeiculo.includes(data) && this.listaVeiculo.push(data);
      }
    );
  }

  gerarJson() {
    return JSON.stringify(this.listaVeiculo, null, 2);
  }

}