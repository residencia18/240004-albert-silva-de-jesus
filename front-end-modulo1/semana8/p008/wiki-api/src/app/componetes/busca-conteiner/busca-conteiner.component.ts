import { Component, EventEmitter, Output } from '@angular/core';
import { BuscaApiService } from '../../services/busca-api.service';

@Component({
  selector: 'app-busca-conteiner',
  templateUrl: './busca-conteiner.component.html',
  styleUrl: './busca-conteiner.component.css'
})
export class BuscaConteinerComponent {

  titulo: string = '';
  respostaApi: any;

  @Output() resultPesquisa: EventEmitter<any> = new EventEmitter<any>();

  constructor(private buscaApiService: BuscaApiService) {
  }

  public buscar(): void {
    this.buscaApiService.buscaService(this.titulo).subscribe(
      (resposta) => {
        console.log(resposta);
        this.respostaApi = resposta;
        this.buscaApiService.setResultadoApi(this.respostaApi);
        this.resultPesquisa.emit(this.respostaApi);
      },
      (erro) => {
        console.log(erro);
      }
    );
  }
}