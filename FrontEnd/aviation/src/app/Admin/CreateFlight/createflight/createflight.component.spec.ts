import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateflightComponent } from './createflight.component';

describe('CreateflightComponent', () => {
  let component: CreateflightComponent;
  let fixture: ComponentFixture<CreateflightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateflightComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateflightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
