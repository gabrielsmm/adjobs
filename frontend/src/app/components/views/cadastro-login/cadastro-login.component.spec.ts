import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroLoginComponent } from './cadastro-login.component';

describe('LoginComponent', () => {
  let component: CadastroLoginComponent;
  let fixture: ComponentFixture<CadastroLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroLoginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
