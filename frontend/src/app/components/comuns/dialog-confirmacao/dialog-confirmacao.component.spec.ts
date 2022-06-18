import { DialogConfirmacaoComponent } from './dialog-confirmacao.component';
import { ComponentFixture, TestBed } from '@angular/core/testing';

describe('DialogComponent', () => {
  let component: DialogConfirmacaoComponent;
  let fixture: ComponentFixture<DialogConfirmacaoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogConfirmacaoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogConfirmacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
