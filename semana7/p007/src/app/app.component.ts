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
  propriedadeSelecionada: string = '';
  listaVeiculos: any[] = [];

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

  setValorPropriedade(propriedade: string) {
    this.propriedadeSelecionada = propriedade;
  }

  setVeiculosLista(veiculo: any) {
    veiculo && !this.listaVeiculos.includes(veiculo) && this.listaVeiculos.push(veiculo);
    console.log('this.listaVeiculos', this.listaVeiculos);
  }
}