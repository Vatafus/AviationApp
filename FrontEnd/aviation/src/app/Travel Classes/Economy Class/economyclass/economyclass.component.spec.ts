import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EconomyclassComponent } from './economyclass.component';

describe('EconomyclassComponent', () => {
  let component: EconomyclassComponent;
  let fixture: ComponentFixture<EconomyclassComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EconomyclassComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EconomyclassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
