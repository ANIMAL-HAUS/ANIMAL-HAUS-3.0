import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckoutsComponentsComponent } from './checkouts-components.component';

describe('CheckoutsComponentsComponent', () => {
  let component: CheckoutsComponentsComponent;
  let fixture: ComponentFixture<CheckoutsComponentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CheckoutsComponentsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CheckoutsComponentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
