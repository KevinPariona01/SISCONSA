import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentoSubirComponent } from './documento-subir.component';

describe('DocumentoSubirComponent', () => {
  let component: DocumentoSubirComponent;
  let fixture: ComponentFixture<DocumentoSubirComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocumentoSubirComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentoSubirComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
