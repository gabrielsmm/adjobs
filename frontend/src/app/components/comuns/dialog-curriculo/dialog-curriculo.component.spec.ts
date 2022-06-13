import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogCurriculoComponent } from './dialog-curriculo.component';

describe('DialogCurriculoComponent', () => {
  let component: DialogCurriculoComponent;
  let fixture: ComponentFixture<DialogCurriculoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogCurriculoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogCurriculoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
