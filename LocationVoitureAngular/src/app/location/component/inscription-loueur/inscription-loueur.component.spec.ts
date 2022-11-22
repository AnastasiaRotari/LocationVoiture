import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptionLoueurComponent } from './inscription-loueur.component';

describe('InscriptionLoueurComponent', () => {
  let component: InscriptionLoueurComponent;
  let fixture: ComponentFixture<InscriptionLoueurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InscriptionLoueurComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InscriptionLoueurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
