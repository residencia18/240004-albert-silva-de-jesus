import { TestBed } from '@angular/core/testing';

import { BuscaApiService } from './busca-api.service';

describe('BuscaApiService', () => {
  let service: BuscaApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BuscaApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
