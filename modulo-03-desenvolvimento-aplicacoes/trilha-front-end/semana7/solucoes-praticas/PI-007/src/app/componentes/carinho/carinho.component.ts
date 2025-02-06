import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-carinho',
  templateUrl: './carinho.component.html',
  styleUrl: './carinho.component.css'
})
export class CarinhoComponent {
  @Input() carinho: any[] = [];
}
