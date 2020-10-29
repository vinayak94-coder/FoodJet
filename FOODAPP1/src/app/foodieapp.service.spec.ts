import { TestBed } from '@angular/core/testing';

import { FoodieappService } from './foodieapp.service';

describe('FoodieappService', () => {
  let service: FoodieappService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FoodieappService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
