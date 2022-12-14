import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Boeng757Component } from './boeng757.component';

describe('Boeng757Component', () => {
  let component: Boeng757Component;
  let fixture: ComponentFixture<Boeng757Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Boeng757Component]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Boeng757Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
