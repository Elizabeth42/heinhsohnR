import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PersonaDTO } from '../../dto/persona.dto';
import { GestionarPersonaService } from '../../servicios/gestionar.persona.service';

@Component({
    selector: 'gestionar-persona',
    templateUrl: './gestionarPersona-Component.html'
})
export class GestionarPersonaComponent implements OnInit {

     /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarPersonaForm : FormGroup;

    /**
     * Atributo que contendra la informacion de la persona
     */
    public persona: PersonaDTO;

    /**
     * Atributo que contendra la lista de personas creados
     */
    public listaPersonas : Array<PersonaDTO>;
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
        private gestionarPersonaService : GestionarPersonaService) {
            this.gestionarPersonaForm = this.fb.group({
                nombre: [null, Validators.required],
                numIdentificacion: [null]
            });
    }
  
      /**
       * @description Evento angular que se ejecuta al invocar el componente
       */
      ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        console.log("------------------------------------");
          this.persona = new PersonaDTO();
          this.listaPersonas = new Array<PersonaDTO>();
          this.consultarPersonas();
            this.editar = false;
      }
      /**
       * metodo encargado de consultar las personas existentes
       */
      public consultarPersonas(): void{
        this.gestionarPersonaService.consultarPersonas().subscribe(listaPersonas => {
            this.listaPersonas = listaPersonas;
        }, error => {
            console.log(error);
        });
      }

       /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     */
    public crearActualizarPersona() : void {
        this.flagC=true;
        
        if(this.gestionarPersonaForm.invalid) {
          return;
        }
        this.persona = new PersonaDTO();
        this.persona.nombre = this.gestionarPersonaForm.controls.nombre.value;
        this.persona.numIdentificacion = this.gestionarPersonaForm.controls.numIdentificacion.value;

        
        if (this.editar == false) {
          this.gestionarPersonaService.crearPersona(this.persona).subscribe(resultadoDTO => {
              console.log(resultadoDTO.exitoso);
              if(resultadoDTO.exitoso) {
                  this.consultarPersonas();
                  this.limpiarFormulario();
                  this.msgError = resultadoDTO.mensajeEjecucion;
              }
          }, error => {
              console.log(error);
          });  
        }else{
            //this.comic.id = this.id;
            this.gestionarPersonaService.modificarPersonas(this.persona).subscribe(resultadoDTO => {
              if(resultadoDTO.exitoso) {
                  this.consultarPersonas();
                  this.limpiarFormulario();
                  this.msgError = resultadoDTO.mensajeEjecucion;
  
              }
          }, error => {
              console.log(error);
          });
        }
    }



    /**
     * @description Metodo que se encarga por medio de una posicion de permitir
     * al usuario modificar el campo que desee del comic
     * @author Laura Elizabeth Castellanos Ducon
     */
    public editarPersona(posicion:number) : void {
        this.editar=true;     
        //mostrara la informacion que contiene el comic
        this.gestionarPersonaForm.controls.nombre.setValue(this.listaPersonas[posicion-1].nombre);
        this.gestionarPersonaForm.controls.numIdentificacion.setValue(this.listaPersonas[posicion-1].numIdentificacion);
        this.gestionarPersonaForm.controls.numIdentificacion.disable;

    }

         /**
     * @description Metodo que se encarga de dejar en blanco el formulario
     * @author Laura Elizabeth Castellanos Ducon
     */
    private limpiarFormulario() : void {      
        this.editar = false;  
        this.gestionarPersonaForm.controls.nombre.setValue(null);
        this.gestionarPersonaForm.controls.numIdentificacion.setValue(null);
    }
    /**
     * permite hacer la redireccion al componente de proveedores
     */
    public revisarProveedores(){
        this.router.navigate(['gestionar-proveedor']);
    }
}