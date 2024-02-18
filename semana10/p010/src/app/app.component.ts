import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { JreaderService } from './services/jreader.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent {
  
  title = 'p007';

  salvarVeiculo: any;

  constructor(private jreaderServico: JreaderService) { }

  ngOnInit() {
    this.jreaderServico.getVeiculo().subscribe(
      data => {
        this.salvarVeiculo = data;
      }
    );
  }
  setVeiculosLista() {
    this.jreaderServico.setListVeiculos(this.salvarVeiculo.Name);
  }
}