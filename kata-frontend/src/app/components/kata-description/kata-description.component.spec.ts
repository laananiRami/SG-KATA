import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KataDescriptionComponent } from './kata-description.component';

describe('KataDescriptionComponent', () => {
  let component: KataDescriptionComponent;
  let fixture: ComponentFixture<KataDescriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [KataDescriptionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(KataDescriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
