import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransformModalComponent } from './transform-modal.component';

describe('TransformModalComponent', () => {
  let component: TransformModalComponent;
  let fixture: ComponentFixture<TransformModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TransformModalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransformModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
