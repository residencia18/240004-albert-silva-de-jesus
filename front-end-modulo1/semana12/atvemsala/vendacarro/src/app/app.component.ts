import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormadicionarComponent } from './formadicionar/formadicionar.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormadicionarComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'vendacarro';
}
