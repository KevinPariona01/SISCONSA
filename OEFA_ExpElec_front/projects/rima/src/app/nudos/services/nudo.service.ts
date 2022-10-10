import { Injectable } from '@angular/core';
import { XsEndpoint, XsHttpApiService } from '@expertsystems/xs-angular-common';
import { XsAppGlobalsService } from '@expertsystems/xs-oefa-plusd-shared';
import { rima_endpoint } from 'projects/rima/src/util/endpoints';

@Injectable({
  providedIn: 'root'
})
export class NudoService {

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
      '/nudo/listar',
      parametro
    );
  }

  listarPadre(parametro): any {
    return this.xsHttpApiService.post(
      this.endpoint,
      '/nudo/listarPadre',
      parametro
    );
  }

  listarDepartamentos(parametro): any {
    return this.xsHttpApiService.post(
      this.endpoint,
      '/nudo/listarDepartamentos',
      parametro
    );
  }

  insertarNudoUbigeo(parametro): any {
    return this.xsHttpApiService.post(
      this.endpoint,
      '/nudo/insertarNudoUbigeo',
      parametro
    );
  }

  insertarNudo(parametro): any {
    return this.xsHttpApiService.post(
      this.endpoint,
      '/nudo/insertarNudo',
      parametro
    );
  }
  
  setEstadoNudoUbigeo(parametro): any {
    return this.xsHttpApiService.post(
      this.endpoint,
      '/nudo/setEstadoNudoUbigeo',
      parametro
    );
  }

  eliminarNudoUbigeo(parametro): any {
    return this.xsHttpApiService.post(
      this.endpoint,
      '/nudo/eliminarNudoUbigeo',
      parametro
    );
  }

  eliminarNudo(parametro): any {
    return this.xsHttpApiService.post(
      this.endpoint,
      '/nudo/eliminarNudo',
      parametro
    );
  }

  eliminarNudoUbigeoConNudo(parametro): any {
    return this.xsHttpApiService.post(
      this.endpoint,
      '/nudo/eliminarNudoUbigeoConNudo',
      parametro
    );
  }
  
}
