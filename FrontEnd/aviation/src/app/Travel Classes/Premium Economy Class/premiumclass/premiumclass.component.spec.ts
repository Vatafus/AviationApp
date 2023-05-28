import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PremiumclassComponent } from './premiumclass.component';

describe('PremiumclassComponent', () => {
  let component: PremiumclassComponent;
  let fixture: ComponentFixture<PremiumclassComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PremiumclassComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PremiumclassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
