import { Directive, ElementRef, OnInit, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appVeiculo]'
})
export class VeiculoDirective implements OnInit {

  constructor(private elemento: ElementRef, private rederizador: Renderer2) { }

  ngOnInit(): void {
    this.rederizador.setStyle(this.elemento.nativeElement, 'background-color', '#2335D6');
    this.rederizador.setStyle(this.elemento.nativeElement, 'color', 'white');
  }

}