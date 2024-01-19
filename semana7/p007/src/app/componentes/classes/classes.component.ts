import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-classes',
  templateUrl: './classes.component.html',
  styleUrl: './classes.component.css'
})
export class ClassesComponent {
  @Input() categorias: any;
  @Output() categoriaSelecionada = new EventEmitter<{titulo : string, veiculos : []}>();

  pegarChaves(): string[] {
    return this.categorias ? Object.keys(this.categorias) : [];
  }

  selecionarCategoria(categoria: string): void {
    this.categoriaSelecionada.emit({titulo: categoria, veiculos: this.categorias[categoria]}); 
  }
}
