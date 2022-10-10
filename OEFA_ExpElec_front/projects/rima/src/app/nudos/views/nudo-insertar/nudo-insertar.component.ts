import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { lazyLoadGroupCollapse } from '@syncfusion/ej2-angular-grids';
import { Nudos } from '../../../helpers/interface/nudo.interface';
import { NudoService } from '../../services/nudo.service';

@Component({
  selector: 'app-nudo-insertar',
  templateUrl: './nudo-insertar.component.html',
  styleUrls: ['./nudo-insertar.component.css']
})
export class NudoInsertarComponent implements OnInit {

  nudo: Nudos;

  constructor(
    public nudoService: NudoService,
    public dialogRef: MatDialogRef<NudoInsertarComponent>,
  ) { }


  ngOnInit(): void {
    this.nudo = {
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
  }


  guardar(newForm){
    console.log("Guardando datos: ", this.nudo);
    this.nudoService.insertarNudo(this.nudo).then((res) => {
      console.log('guardando', res);
      try {
        if (res.estado) {
          console.log(res.estado);
          this.dialogRef.close({ flag: true, data: this.nudo });
        } else {
          console.log(res);
        }
      } catch (error) {
        console.error(error);
      }
    });
  }

}
