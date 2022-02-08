import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstagiosComponent } from './estagios.component';

describe('EstagiosComponent', () => {
  let component: EstagiosComponent;
  let fixture: ComponentFixture<EstagiosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EstagiosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EstagiosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
