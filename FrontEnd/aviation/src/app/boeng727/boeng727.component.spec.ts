import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Boeng727Component } from './boeng727.component';

describe('Boeng727Component', () => {
  let component: Boeng727Component;
  let fixture: ComponentFixture<Boeng727Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Boeng727Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Boeng727Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
