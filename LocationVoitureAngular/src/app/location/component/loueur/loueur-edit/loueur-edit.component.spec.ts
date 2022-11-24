import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoueurEditComponent } from './loueur-edit.component';

describe('LoueurEditComponent', () => {
  let component: LoueurEditComponent;
  let fixture: ComponentFixture<LoueurEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoueurEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoueurEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
