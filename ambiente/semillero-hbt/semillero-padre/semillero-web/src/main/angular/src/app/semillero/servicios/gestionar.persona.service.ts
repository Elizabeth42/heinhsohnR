import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { PersonaDTO } from '../dto/persona.dto';
import { AbstractService } from '../services/template.service';

/**
 * @description Servicio encargado de llamar a los servicios REST de gestionar persona
 * @author Laura Elizabeth Castellanos Ducon
 */
@Injectable({
  providedIn: 'root'
})
export class GestionarPersonaService extends AbstractService {
    
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
  public consultarPersonas(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarPersona/consultarPersonas');
  }

  /**
   * @description Metodo encargado de invocar el servicio REST crear persona
   * @param personaDTO contiene la informacion de laa persona a persistir
   */
  public crearPersona(personaDTO : PersonaDTO): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarPersona/crear',personaDTO);
  }

    /**
   * @description Metodo encargado de invocar el servicio REST de modificar personas
   * @author Laura Elizabeth Castellanos Ducon <eliizabeth.42@gmail.com>
   */
  public modificarPersonas(personaDTO: PersonaDTO): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarComic/modificar',personaDTO);
  }
}