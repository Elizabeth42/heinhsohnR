import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProveedorDTO } from '../../dto/proveedor.dto';
import { GestionarProveedorService } from '../../servicios/gestionar.proveedor.service';

@Component({
    selector: 'gestionar-proveedor',
    templateUrl: './gestionarProveedor-Component.html'
})
export class GestionarProveedorComponent implements OnInit {

     /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarProveedorForm : FormGroup;

    /**
     * Atributo que contendra la informacion de la persona
     */
    public proveedor: ProveedorDTO;

    /**
     * Atributo que contendra la lista de personas creados
     */
    public listaProveedores : Array<ProveedorDTO>;
    /**
     * sirve para indicar que se esta creando
     */
    public  flagC: boolean;
    /**
     * sirve para indicar que se esta editando
     */
    public  editar: boolean;

     /**
     * permitira validar e indicar al usuario el error cometido
     */
    public msgError:string;

    /**
     * @description Este es el constructor del componente GestionarPersona
     * @author Laura Elizabeth Castellanos Ducon
     * 
     */
    constructor(private fb : FormBuilder,
        private router : Router,
        private gestionarProveedorService : GestionarProveedorService) {
            this.gestionarProveedorForm = this.fb.group({
                direccion: [null, Validators.required],
                dateNew: [null],
                estado: [null],
                persona: [null]
            });
    }
  
      /**
       * @description Evento angular que se ejecuta al invocar el componente
       */
      ngOnInit(): void {
        
          this.proveedor = new ProveedorDTO();
          this.listaProveedores = new Array<ProveedorDTO>();
          this.consultarProveedores();
            this.editar = false;
      }

      /**
       * metodo encargado de consultar las personas existentes
       */
      public consultarProveedores(): void{
        this.gestionarProveedorService.consultarProveedores().subscribe(listaProveedores => {
            this.listaProveedores = listaProveedores;
        }, error => {
            console.log(error);
        });
      }
}