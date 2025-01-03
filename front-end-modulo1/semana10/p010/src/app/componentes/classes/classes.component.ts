import { Component, EventEmitter, Input, Output } from '@angular/core';
import { JreaderService } from '../../services/jreader.service';

@Component({
  selector: 'app-classes',
  templateUrl: './classes.component.html',
  styleUrl: './classes.component.css'
})
export class ClassesComponent {

  listaCategorias: string[] = [];
  constructor(private jreaderServico: JreaderService) { }

  ngOnInit() {
    this.jreaderServico.getJsonVeiculos().subscribe(
      data => {
        this.listaCategorias = Object.keys(data);
      }
    );
  }

  selecionarCategoria(categoria: string): void {
    this.jreaderServico.getJsonVeiculos().subscribe(
      data => {
        this.jreaderServico.setCategoria({cat:categoria, veiculos:data[categoria]});
      }
    )
  }
}