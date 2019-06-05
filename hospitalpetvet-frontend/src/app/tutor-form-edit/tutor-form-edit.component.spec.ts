import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TutorFormEditComponent } from './tutor-form-edit.component';

describe('TutorFormComponent', () => {
  let component: TutorFormEditComponent;
  let fixture: ComponentFixture<TutorFormEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TutorFormEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TutorFormEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
