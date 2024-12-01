import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { TransformService } from '../../services/transform.service';
import { CommonModule } from '@angular/common';
import { TransformResult } from '../../models/transform-result';

@Component({
  selector: 'app-modal',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './modal.component.html',
  styleUrl: './modal.component.scss'
})
export class ModalComponent {
  isVisible = false;
  isLoading = false;
  inputValue?: String;
  transformResult = {} as TransformResult;
  form = new FormGroup({
    number: new FormControl('', {
      validators: [
        Validators.required,
        Validators.min(0),
        Validators.max(100),
        Validators.pattern('^[0-9]*$')
      ],
      nonNullable: true
    })
  });

  constructor(private transformService: TransformService){}

  get numberControl() {
    return this.form.controls.number;
  }

  open(): void {
    this.isVisible = true;
  }

  close(): void {
    this.isVisible = false;
    this.inputValue = new String();
    this.form.reset();
  }

  reset(): void {
    this.form.reset();
    this.transformResult = {} as TransformResult;
  }

  onSubmit(): void {
    if (this.form.valid) {
      this.transformResult = {} as TransformResult;
      this.isLoading = true;
      
      const number = this.numberControl.value;
      this.inputValue = number; 

      this.transformService.transform(Number(number)).subscribe({
        next: (response) => {
          this.transformResult.result = response.result;
          this.isLoading = false;
        },
        error: (err) => {
          this.transformResult.error = err.error?.message ?? 'Une erreur est survenue';
          this.isLoading = false;
        }
      });
    } else {
      this.form.markAllAsTouched();
    }
  }
}
