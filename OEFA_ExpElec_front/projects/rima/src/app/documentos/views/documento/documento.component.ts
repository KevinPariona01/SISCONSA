import { Documento } from './../../../helpers/interface/documento.interface';
import { DocumentoService } from './../../services/documento.service';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-documento',
  templateUrl: './documento.component.html',
  styleUrls: ['./documento.component.css']
})
export class DocumentoComponent implements OnInit {

  public documentos = new MatTableDataSource();

  documentos1:any= [
    {
      id:0,
      html:'',
      documento:'',
      comentario:''
    }
  ];

  displayedColumns: string[] = [
    'id',
    'html',
  ];


  documento1:any;
  documento = '';

  constructor(
    public documentoService: DocumentoService,
  ) { }

  ngOnInit(): void {
  }


  obtenerDocumento(){
    this.documentoService.documento({}).then((res)=>{
      let dato = document.getElementById("test");
      dato.innerHTML = res.content;
    });
  }

  insertarDocumento(){
    const test:any = document.getElementById('test');
    let i = 0
    for (const label of test.children ){
      for (const lab of label.children ){
        i++;
        let documento1 = {
          id : i,
          html : lab.innerHTML
       }
        this.insertar(documento1);
      }
    }
    console.log(this.documento1);
  }


  insertar(documento){
      this.documentoService.insertar(documento).then((res) => {
        console.log('editando', res);
        try {
          if (res.estado) {
            console.log(res.estado);
          } else {
            console.log(res);
          }
        } catch (error) {
          console.error(error);
        }
      });
  }

  mostrarDocumento(){
    this.documentoService.listar({}).then((res) => {
      this.documentos = new MatTableDataSource<any>(res.content.dataSource);
      this.documentos1 = res.content.dataSource;
    });
    console.log('documento: ',this.documentos); 
    console.log('documento1: ',this.documentos1);
  }
  
  dataDocumentos(){
    console.log(this.documentos1);
    let data = document.getElementById('dataDocumentos');
    this.documentos1.forEach(element => {
        data.innerHTML += element.html;
      
    });
  }
}
