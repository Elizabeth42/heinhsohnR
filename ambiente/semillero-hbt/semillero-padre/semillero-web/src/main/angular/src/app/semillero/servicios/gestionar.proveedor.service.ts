import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { ProveedorDTO } from '../dto/proveedor.dto';
import { AbstractService } from '../services/template.service';

/**
 * @description Servicio encargado de llamar a los servicios REST de gestionar proveedor
 * @author Laura Elizabeth Castellanos Ducon
 */
@Injectable({
  providedIn: 'root'
})
export class GestionarProveedorService extends AbstractService {
    /**
   * Constructor de la clase
   */
  constructor(injector: Injector, private httpClient : HttpClient) {
    super(injector);
  }
  
  /**
   * @description Metodo encargado de invocar el servicio REST consultar personas
   * @author Laura Elizabeth Castellanos Ducon
   */
  public consultarProveedores(): Observable<any>  {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/consultarProveedores');
  }
}