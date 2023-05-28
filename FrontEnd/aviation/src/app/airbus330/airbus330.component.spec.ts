import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Airbus330Component } from './airbus330.component';

describe('Airbus330Component', () => {
  let component: Airbus330Component;
  let fixture: ComponentFixture<Airbus330Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Airbus330Component ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Airbus330Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
