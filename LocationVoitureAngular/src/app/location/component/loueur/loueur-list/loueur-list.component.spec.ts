import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoueurListComponent } from './loueur-list.component';

describe('LoueurListComponent', () => {
  let component: LoueurListComponent;
  let fixture: ComponentFixture<LoueurListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoueurListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoueurListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
