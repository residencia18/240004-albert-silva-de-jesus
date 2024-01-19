import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent {
  title = 'p007';
  resultados: any;
  categoriaSelecionada: any;
  veiculoSelecionado: any;

  constructor(public http: HttpClient) {
    console.log('constructor');
  }

  ngOnInit() {
    this.http.get('../assets/veiculos.json')
      .subscribe((data: any) => {
        this.resultados = data;
        console.log('this.resultados', this.resultados);
      });
  }

  setCategoriaSelecionada(categoria: any) {
    this.categoriaSelecionada = categoria;
  }

  setVeiculoSelecionado(veiculo: any) {
    this.veiculoSelecionado = veiculo;
  }
}