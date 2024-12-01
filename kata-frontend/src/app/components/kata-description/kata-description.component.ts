import { Component, ViewChild } from '@angular/core';
import { ModalComponent } from '../shared-modal/modal.component';

@Component({
  selector: 'app-kata-description',
  standalone: true,
  imports: [ModalComponent],
  templateUrl: './kata-description.component.html',
  styleUrl: './kata-description.component.scss'
})
export class KataDescriptionComponent {

  @ViewChild('modal') modalComponent!: ModalComponent;

  openModal(): void {
    this.modalComponent.open();
  }

}
