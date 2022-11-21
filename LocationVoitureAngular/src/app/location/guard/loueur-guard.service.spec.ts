import { TestBed } from '@angular/core/testing';

import { LoueurGuardService } from './loueur-guard.service';

describe('LoueurGuardService', () => {
  let service: LoueurGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoueurGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
