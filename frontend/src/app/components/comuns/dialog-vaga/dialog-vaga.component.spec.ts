import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogVagaComponent } from './dialog-vaga.component';

describe('DialogComponent', () => {
  let component: DialogVagaComponent;
  let fixture: ComponentFixture<DialogVagaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogVagaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogVagaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
