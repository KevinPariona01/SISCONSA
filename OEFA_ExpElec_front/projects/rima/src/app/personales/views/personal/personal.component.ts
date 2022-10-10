import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-personal',
  templateUrl: './personal.component.html',
  styleUrls: ['./personal.component.css']
})
export class PersonalComponent implements OnInit {

  //Header
  displayedColumns: string[] = [
    'id',
    'nudo',
    'dni',
    'nombre',
    'usuario',
    'activo',
    'accion',
  ];

  nudos: any = [
    {
      idItem:0,
      valor:'v1'
    },
  ];

  constructor() { }

  ngOnInit(): void {
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    //this.catalogos.filter = filterValue.trim().toLowerCase();
  }

}
