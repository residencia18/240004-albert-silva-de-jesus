import { Component } from '@angular/core';

@Component({
  selector: 'app-arara',
  templateUrl: './arara.component.html',
  styleUrl: './arara.component.css'
})
export class AraraComponent {

  nome: string = 'Arara';
  link: string = 'https://github.com/';
  imagem: string = 'https://cdn.awsli.com.br/600x450/1225/1225697/produto/47027787/caneca-java-logo-3ff0c50b.jpg';

  public onClick(): void {
    alert('Clicou em mim!');
  }
}
