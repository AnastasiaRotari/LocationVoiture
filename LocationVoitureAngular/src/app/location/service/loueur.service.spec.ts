import { TestBed } from '@angular/core/testing';

import { LoueurService } from './loueur.service';

describe('LoueurService', () => {
  let service: LoueurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoueurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
