import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-resultado-container',
  templateUrl: './resultado-container.component.html',
  styleUrl: './resultado-container.component.css'
})
export class ResultadoContainerComponent {

  @Input('resultadosDaApi') resultados: any;

  linkWikiPedia() {
    return `https://en.wikipedia.org/wiki/${this.resultados.parse.title}`
  }
}