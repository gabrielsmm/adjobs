import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AreaEmpresaComponent } from './area-empresa.component';

describe('AreaEmpresaComponent', () => {
  let component: AreaEmpresaComponent;
  let fixture: ComponentFixture<AreaEmpresaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AreaEmpresaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AreaEmpresaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
