import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JreaderComponent } from './jreader.component';

describe('JreaderComponent', () => {
  let component: JreaderComponent;
  let fixture: ComponentFixture<JreaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [JreaderComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(JreaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
