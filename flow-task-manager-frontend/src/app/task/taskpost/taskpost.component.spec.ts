import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskpostComponent } from './taskpost.component';

describe('TaskpostComponent', () => {
  let component: TaskpostComponent;
  let fixture: ComponentFixture<TaskpostComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaskpostComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaskpostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
