import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultadoContainerComponent } from './resultado-container.component';

describe('ResultadoContainerComponent', () => {
  let component: ResultadoContainerComponent;
  let fixture: ComponentFixture<ResultadoContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ResultadoContainerComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ResultadoContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
