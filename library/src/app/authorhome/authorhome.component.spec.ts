import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorhomeComponent } from './authorhome.component';

describe('AuthorhomeComponent', () => {
  let component: AuthorhomeComponent;
  let fixture: ComponentFixture<AuthorhomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthorhomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorhomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
