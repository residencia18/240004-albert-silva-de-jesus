import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentlistarComponent } from './componentlistar.component';

describe('ComponentlistarComponent', () => {
  let component: ComponentlistarComponent;
  let fixture: ComponentFixture<ComponentlistarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ComponentlistarComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ComponentlistarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
