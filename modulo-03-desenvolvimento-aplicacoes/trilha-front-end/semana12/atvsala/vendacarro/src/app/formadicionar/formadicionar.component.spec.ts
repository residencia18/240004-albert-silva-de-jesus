import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormadicionarComponent } from './formadicionar.component';

describe('FormadicionarComponent', () => {
  let component: FormadicionarComponent;
  let fixture: ComponentFixture<FormadicionarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormadicionarComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormadicionarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
