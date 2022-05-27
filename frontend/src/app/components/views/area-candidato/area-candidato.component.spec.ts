import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AreaCandidatoComponent } from './area-candidato.component';

describe('CandidaturasComponent', () => {
  let component: AreaCandidatoComponent;
  let fixture: ComponentFixture<AreaCandidatoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AreaCandidatoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AreaCandidatoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
