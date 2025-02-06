import { Component, Input } from '@angular/core';
import { JreaderService } from '../../services/jreader.service';

@Component({
  selector: 'app-valor-propriedades',
  templateUrl: './valor-propriedades.component.html',
  styleUrl: './valor-propriedades.component.css'
})
export class ValorPropriedadesComponent {

  propriedade: string = '';

  constructor(private jreaderSevice: JreaderService) { }

  ngOnInit() {
    this.jreaderSevice.getPropriedade().subscribe(
      data => {
        this.propriedade = data;
      }
    );
  }
}
