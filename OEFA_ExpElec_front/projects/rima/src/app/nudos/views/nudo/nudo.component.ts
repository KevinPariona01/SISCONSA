import { element } from 'protractor';
import { NudoInsertarComponent } from './../nudo-insertar/nudo-insertar.component';
import { NudosEditarComponent } from './../nudo-editar/nudo-editar.component';
import { NudoService } from './../../services/nudo.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmarComponent } from '../../../general/confirmar/confirmar.component';

@Component({
  selector: 'app-nudo',
  templateUrl: './nudo.component.html',
  styleUrls: ['./nudo.component.css']
})
export class NudoComponent implements OnInit {

  idNudoPadre;

  //Lista de nudos
  public nudos = new MatTableDataSource();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort, { static: false }) sort: MatSort;

  //Header
  Ubigeos: string[] = [
    'id',
    'nudo',
    'departamento',
    'ubigeo',
    'activo',
    'accion',
  ];
  Nudos: string[] = [
    'id',
    'nudo',
    'descripcion',
    'activo',
    'accion',
  ];
  
  nudosPadre: any = [];
  

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.nudos.filter = filterValue.trim().toLowerCase();
  }

  constructor(
    public nudoService:NudoService,
    public dialog: MatDialog,
  ) { }

  ngOnInit(): void {
    this.getNudos();
    this.getPadres();
  }

  getNudos(){
    let parametros = {
      idNudoPadre: this.idNudoPadre,
    };
    this.nudoService.listar(parametros).then((res) => {
      res.content.dataSource.forEach((element) => {
        if (element.activo == '1') {
          element.activo = true;
        } else {
          element.activo = false;
        }
      });
      this.nudos = new MatTableDataSource<any>(res.content.dataSource);
      this.nudos.sort = this.sort;
      this.nudos.paginator = this.paginator;
    });
  }

  getPadres(){
    this.nudoService.listarPadre({}).then((res) => {
      this.nudosPadre = res.content.dataSource;
    });
  }

  

  //Activar filtro de catalogos
  select(value) {//
    console.log(value);
    this.idNudoPadre = value;
    this.getNudos();
  }

  //Actualizar Item
  editItem() {
    const dialogRef = this.dialog.open(NudosEditarComponent, {
      width: '750px',
      panelClass: 'custom-dialog-container',
      data: 
      {},
    });
    dialogRef.afterClosed().subscribe((result) => {
      try {        
        this.getNudos();
        this.getPadres();

      } catch (error) {
        console.log(error);
        this.getNudos();
        this.getPadres();
      }
    });
  }

  estado(element){
    let setEstado = '1';
    let msn = '¿Seguro que desea Activar el Ubigeo ';

    if (element.activo || element.activo == '1') {
      setEstado = '0';
      msn = '¿Seguro que desea Desactivar el Ubigeo ';
    }
    const dialogRef = this.dialog.open(ConfirmarComponent, {
      width: '700px',
      data: { titulo: msn + element.departamento + '?' },
    });
    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        let parametro = {
          idNudo: element.idNudo,
          activo: setEstado,
        };
        console.log(parametro);
        this.nudoService.setEstadoNudoUbigeo(parametro).then((res) => {
          if (res.estado) {
            this.getNudos();
            this.getPadres();
          } else {
            console.log(res);
          }
        });  
      } else {
        this.getNudos();
        this.getPadres();
      }
    });
  }

  eliminar(element){
    let msn = '¿Seguro que desea Eliminar el ubigeo ';
    const dialogRef = this.dialog.open(ConfirmarComponent, {
      width: '700px',
      data: { titulo: msn + element.departamento + '?' },
    });
    dialogRef.afterClosed().subscribe((result) => {
      console.log(result);
      if (result) {
        let parametro = {
          idNudo: element.idNudo,
          regisActivo: 0,
        };
        console.log(parametro);
        this.nudoService.eliminarNudoUbigeo(parametro).then((res) => {
          if (res.estado) {
            this.getNudos();
            this.getPadres();
          } else {
            console.log(res);
          }
        });  
      } else {
        //this.getCatalogos();
        this.getNudos();
        this.getPadres();
      }
    });
  }
  
  eliminarNudo(element){
    let msn = '¿Seguro que desea Eliminar el nudo ';
    const dialogRef = this.dialog.open(ConfirmarComponent, {
      width: '700px',
      data: { titulo: msn + element.nombre + '?' },
    });
    dialogRef.afterClosed().subscribe((result) => {
      console.log(result);
      if (result) {
        let parametro = {
          idNudo: element.idNudo,
          regisActivo: 0,
        };
        console.log(parametro);
        this.nudoService.eliminarNudo(parametro).then((res) => {
          if (res.estado) {
            this.getNudos();
            this.getPadres();
          } else {
            console.log(res);
          }
        });
        this.nudoService.eliminarNudoUbigeoConNudo(parametro).then((res) => {
          if (res.estado) {
            this.getNudos();
            this.getPadres();
          } else {
            console.log(res);
          }
        });  
      } else {
        //this.getCatalogos();
        this.getNudos();
        this.getPadres();
      }
    });
  }

  insertarNudo(){
    const dialogRef = this.dialog.open(NudoInsertarComponent, {
      width: '750px',
      panelClass: 'custom-dialog-container',
      data: 
      {},
    });
    dialogRef.afterClosed().subscribe((result) => {
      try {        
        this.getNudos();
        this.getPadres();

      } catch (error) {
        console.log(error);
        this.getNudos();
        this.getPadres();
      }
    });
  }

  test(element){
    console.log("dato: ",element.idNudo)
    this.idNudoPadre = element.idNudo;
    this.getNudos();
  }

}
