
import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarComicService } from '../../servicios/gestionar.comic.service';
import { stringify } from 'querystring';

/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'gestionar-comic',
    templateUrl: './gestionar-comic.html',
    styleUrls: ['./gestionar-comic.css']
})
export class GestionarComicComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarComicForm : FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaComics : Array<ComicDTO>;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;
    public flag:boolean;
    /**
     * se encarga de almacenar el nombre del comic eliminado
     */
    public deleteName: string;

    public flagC:boolean;
    /**
     * indicara cuando se presente un nuevo error
     */
    public error: boolean;
    /**
     * permitira validar e indicar al usuario el error cometido
     */
    public msgError:string;
    /**
     * representa si se esta editando o creando un componente
     */
    public editar:boolean;
    /**
     * identificador de la edicion
     */
    public id:string;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    constructor(private fb : FormBuilder,
      private router : Router,
      private gestionarComicService : GestionarComicService) {
      this.gestionarComicForm = this.fb.group({
          nombre : [null, Validators.required],
          editorial : [null],
          tematica : [null],
          coleccion : [null],
          numeroPaginas : [null],
          precio : [null],
          autores : [null],
          color : [null]
      });
  }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        this.comic = new ComicDTO();
        this.listaComics = new Array<ComicDTO>();
        this.editar= false;
        this.flagC=false;

        this.consultarComics();
    }

        /**
     * @description Metodo encargado de consultar los comics existentes
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    public consultarComics() : void {
      this.gestionarComicService.consultarComics().subscribe(listaComics => {
          this.listaComics = listaComics;
      }, error => {
          console.log(error);
      });
  }

    /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     */
    public crearActualizarComic() : void {
        this.submitted = true;
        this.flagC=true;
        this.flag=false;
        if(this.gestionarComicForm.invalid) {
          return;
        }
        this.comic = new ComicDTO();
        this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
        this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
        this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
        this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
        this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
        this.comic.precio = this.gestionarComicForm.controls.precio.value;
        this.comic.autores = this.gestionarComicForm.controls.autores.value;
        this.comic.color = this.gestionarComicForm.controls.color.value;
        this.comic.cantidad = 12;
        
        if (this.editar == false) {
          this.gestionarComicService.crearComic(this.comic).subscribe(resultadoDTO => {
              if(resultadoDTO.exitoso) {
                  this.consultarComics();
                  this.limpiarFormulario();
                  this.msgError = resultadoDTO.mensajeEjecucion;
              }
          }, error => {
              console.log(error);
          });  
        }else{
          this.comic.id = this.id;
          this.gestionarComicService.modificarComics(this.comic).subscribe(resultadoDTO => {
            if(resultadoDTO.exitoso) {
                this.consultarComics();
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
    public editarComic(posicion:number) : void {
        this.editar=true;     
        //mostrara la informacion que contiene el comic
        this.id = this.listaComics[posicion-1].id;

        this.gestionarComicForm.controls.nombre.setValue(this.listaComics[posicion-1].nombre);
        this.gestionarComicForm.controls.editorial.setValue(this.listaComics[posicion-1].editorial);
        this.gestionarComicForm.controls.tematica.setValue(this.listaComics[posicion-1].tematica);
        this.gestionarComicForm.controls.coleccion.setValue(this.listaComics[posicion-1].coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(this.listaComics[posicion-1].numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(this.listaComics[posicion-1].precio);
        this.gestionarComicForm.controls.autores.setValue(this.listaComics[posicion-1].autores);
        this.gestionarComicForm.controls.color.setValue(this.listaComics[posicion-1].color);
        

    }

     /**
     * @description Metodo que se encarga de dejar en blanco el formulario
     * @author Laura Elizabeth Castellanos Ducon
     */
    private limpiarFormulario() : void {
        this.submitted = false;
        this.editar = false;
        this.id = null;
        this.gestionarComicForm.controls.nombre.setValue(null);
        this.gestionarComicForm.controls.editorial.setValue(null);
        this.gestionarComicForm.controls.tematica.setValue(null);
        this.gestionarComicForm.controls.coleccion.setValue(null);
        this.gestionarComicForm.controls.numeroPaginas.setValue(null);
        this.gestionarComicForm.controls.precio.setValue(null);
        this.gestionarComicForm.controls.autores.setValue(null);
        this.gestionarComicForm.controls.color.setValue(null);
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    get f() { 
        return this.gestionarComicForm.controls;
    }

   /**
     * @description Metodo que se encarga de redireccionar a la consulta del comic
     * @author Laura Elizabeth Castellanos Ducon
     */
    public consultarComponent() : void {
        this.router.navigate(['consultar-comic']);
    }

    /**
     * Este metodo permite ingresar por parametro la posicion a eliminar 
     *       * 
     */
  public deletePosition(posicion:number): void{
    this.error=false;
    this.flagC=false;
    this.flag=true;
    let id  =  this.listaComics[posicion].id; 
    this.gestionarComicService.eliminarComics(id).subscribe(resultadoDTO => {
      if(resultadoDTO.exitoso) {
          this.consultarComics();
      }
   }, error => {
      console.log(error);
  });
  }

  /**
     * Este metodo permite ingresar por parametro la posicion a eliminar 
     *       * 
     */
    public delete(idComic:string): void{
      this.error=false;
      this.flagC=false;
      this.flag=true;
    
      this.gestionarComicService.eliminarComics(idComic).subscribe(resultadoDTO => {
        if(resultadoDTO.exitoso) {
            this.consultarComics();
        }
        this.msgError = resultadoDTO.mensajeEjecucion;
      }, error => {
        console.log(error);
    });
    }
}