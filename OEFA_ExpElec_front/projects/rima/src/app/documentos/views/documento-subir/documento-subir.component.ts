import { Component, OnInit } from '@angular/core';
import { DocumentoService } from '../../services/documento.service';

@Component({
  selector: 'app-documento-subir',
  templateUrl: './documento-subir.component.html',
  styleUrls: ['./documento-subir.component.css']
})
export class DocumentoSubirComponent implements OnInit {

  constructor(
    public documentoService: DocumentoService
  ) { }

  ngOnInit(): void {
  }


  url = '';
  file = File;

  guardar(newForm){
    const url = document.getElementById('archivo').attributes;
    let parametro = {
      documento: this.file
    }
    console.log(url);
    /* this.documentoService.documento(parametro).then((res)=>{
      let dato = document.getElementById("test");
      dato.innerHTML = res.content;
    }); */
  }


}
