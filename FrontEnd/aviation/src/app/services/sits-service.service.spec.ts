import { TestBed } from '@angular/core/testing';

import { SitsServiceService } from './sits-service.service';

describe('SitsServiceService', () => {
  let service: SitsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SitsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
