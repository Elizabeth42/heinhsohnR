import { Component } from '@angular/core';
import { Router } from '@angular/router';
/**
 * @description: este componente se encarga de presentar el autor del proyecto
 * @author: Laura Elizabeth Castellanos Ducon
 */
@Component({
    selector: 'presentacion-component',
    templateUrl: './presentacion-autor-component.html'
  })
  export class PresentacionAutorComponent {
    nombreyciudad: string;
  /**
   * Constructor de la clase
   * @param router permite direccionar a otros componentes
   */
  constructor(private router: Router) {
     this.nombreyciudad= 'Laura Elizabeth Castellanos Ducon - Tunja';
    console.log(this.nombreyciudad);
  }

  /**
   * Evento angular que se ejecuta al iniciar el componente
   */

  }