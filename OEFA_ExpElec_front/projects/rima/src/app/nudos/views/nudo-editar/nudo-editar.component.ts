import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { Nudos } from '../../../helpers/interface/nudo.interface';
import { NudoService } from '../../services/nudo.service';

@Component({
  selector: 'app-nudos-editar',
  templateUrl: './nudo-editar.component.html',
  styleUrls: ['./nudo-editar.component.css'],
})
export class NudosEditarComponent implements OnInit {
  //Lista de departamentos con ubigeo
  departamentos: any = [];
  //Objeto nudo ubigeo
  nudoUbigeo: Nudos;
  //Lista de Nudos
  nudosPadre: any = [];

  constructor(
    public nudoService: NudoService,
    public dialogRef: MatDialogRef<NudosEditarComponent>,
    ) {}

  ngOnInit(): void {
    this.nudoUbigeo = {
      idNudo: 0,
      nombre: '',
      descripcion: '',
      activo: '',
      regisActivo: '',
      departamento: '', //
      idNudoPadre: '', //
      ubigeo: '', //
      ubigeoDpto: 0, //
    };

    this.getDepartamentos();
    this.getPadres();
    console.log('Departamentos: ',this.departamentos);
    
  }

  getDepartamentos() {
    this.nudoService.listarDepartamentos({}).then((res) => {
      this.departamentos = res.content.dataSource;
    });
  }

  getPadres() {
    this.nudoService.listarPadre({}).then((res) => {
      this.nudosPadre = res.content.dataSource;
    });
  }

  guardar(newForm, idNudo, selection){
    console.log('data: ', newForm);
    console.log('nudo: ', idNudo);
    console.log('tamtaño: ', selection._selection.size);
    this.nudoUbigeo.idNudo = idNudo;
    for (let i = 0; i < selection._selection.size; i++) {
      this.nudoUbigeo.departamento = newForm[i].departamento;
      this.nudoUbigeo.ubigeoDpto = newForm[i].ubigeoDpto;
      this.nudoUbigeo.ubigeo = newForm[i].ubigeo;
      console.log(this.nudoUbigeo);
      
      this.nudoService.insertarNudoUbigeo(this.nudoUbigeo).then((res) => {
        console.log('guardando', res);
        try {
          if (res.estado) {
            console.log(res.estado);
            this.dialogRef.close({ flag: true, data: this.nudoUbigeo });
          } else {
            console.log(res);
          }
        } catch (error) {
          console.error(error);
        }
      });
    } 
  }

}
