import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogAlteraSenhaComponent } from './dialog-altera-senha.component';

describe('DialogComponent', () => {
  let component: DialogAlteraSenhaComponent;
  let fixture: ComponentFixture<DialogAlteraSenhaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogAlteraSenhaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogAlteraSenhaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
