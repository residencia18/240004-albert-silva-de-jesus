import { Directive, ElementRef, OnInit, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appCategoria]'
})
export class CategoriaDirective implements OnInit{

  constructor(private elemento: ElementRef, private rederizador: Renderer2) { }
  
  ngOnInit(): void {
    this.rederizador.setStyle(this.elemento.nativeElement, 'background-color', 'blueviolet');
    this.rederizador.setStyle(this.elemento.nativeElement, 'color', 'white');
  }

}