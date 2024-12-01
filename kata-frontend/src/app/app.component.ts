import { Component } from '@angular/core';
import { KataDescriptionComponent } from './components/kata-description/kata-description.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [KataDescriptionComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'kata-frontend';
}
