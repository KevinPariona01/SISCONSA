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

  //public documentos = new MatTableDataSource();

  
  filtro1 = '<span>&nbsp;</span>';
  filtro2 = '<span style="font-weight:bold">&nbsp;</span>';
  filtro3 = "<span style=\"font-family:'Times New Roman'\">&nbsp;</span>"

  documentos1:any= [
    {
      id:0,
      html:'',
      documento:'',
      comentario:''
    }
  ];

  documento:Documento={
    id:0,
    html:'',
    comentario:'',
    documento:''
  };

  constructor(
    public documentoService: DocumentoService,
  ) { }

  ngOnInit(): void {
    this.documento={
      id:0,
      html:'',
      comentario:'',
      documento:''
    };
  }


  //OBTENER DOCUMENTO DEL ADMINISTRADOR DE ARCHIVOS
  obtenerDocumento(){
    this.documentoService.documento({}).then((res)=>{
      let dato = document.getElementById("test");
      dato.innerHTML = res.content;
    });
  }

  //ITERADOR PARA INSERTAR 
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
  }

  //INSERTAR HACIA LA BD
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

  //MUESTRA EL DOCUMENTO DE LA BD 
  mostrarDocumento(){
    this.documentoService.listar({}).then((res) => {
      this.documentos1 = res.content.dataSource;
    });
    //console.log('documento: ',this.documentos); 
    console.log('documento1: ',this.documentos1);
  }
  
  //MUESTRA EL FORMULARIO 
  abrirComentario(id, comentario){
    console.log("ID:", id ); 
    this.documento.id = id;  
    this.documento.comentario = comentario
  }


  //INSERTAR EL FORMULARIO HACIA LA BD
  insertarComentario(newform){
    this.documentoService.insertarComentario(this.documento).then((res) => {
      console.log('insertando comentario...', res);
      try {
        if (res.estado) {
          console.log(res.estado);
        } else {
          console.log(res);
        }
      } catch (error) {
        console.error(error);
      }
      this.mostrarDocumento();
    });
}
  
}
