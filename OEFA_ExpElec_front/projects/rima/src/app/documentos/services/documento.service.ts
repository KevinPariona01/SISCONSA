import { Injectable } from '@angular/core';
import { XsEndpoint, XsHttpApiService } from '@expertsystems/xs-angular-common';
import { XsAppGlobalsService } from '@expertsystems/xs-oefa-plusd-shared';
import { rima_endpoint } from 'projects/rima/src/util/endpoints';

@Injectable({
  providedIn: 'root'
})
export class DocumentoService {

  endpoint: XsEndpoint;

  constructor(
    public xsHttpApiService: XsHttpApiService,
    private xsAppGlobalsService: XsAppGlobalsService
  ) {
    this.endpoint = rima_endpoint;
  }

  listar(parametro): any {
    return this.xsHttpApiService.post(
      this.endpoint,
      '/documento/listar',
      parametro
    );
  }

  insertar(parametro): any {
    return this.xsHttpApiService.post(
      this.endpoint,
      '/documento/insertar',
      parametro
    );
  }

  insertarComentario(parametro): any {
    return this.xsHttpApiService.post(
      this.endpoint,
      '/documento/insertarComentario',
      parametro
    );
  }

  documento(parametro): any {
    return this.xsHttpApiService.post(
        this.endpoint,
        '/documento/documento', parametro
      );
  }

  
}
