import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpregosComponent } from './empregos.component';

describe('EmpregosComponent', () => {
  let component: EmpregosComponent;
  let fixture: ComponentFixture<EmpregosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmpregosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpregosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
