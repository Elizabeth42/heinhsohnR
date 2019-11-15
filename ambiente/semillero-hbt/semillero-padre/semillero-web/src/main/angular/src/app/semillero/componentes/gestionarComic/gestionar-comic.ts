
import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

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

    public idComic : number = 0;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;
    public flag:boolean;
    /**
     * se encarga de almacenar el nombre del comic eliminado
     */
    public deleteName: string;
    /**
     * se encarga de almacenar el nombre del comic creado
     */
    public createName: string;
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
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    constructor(private fb : FormBuilder,
        private router : Router) {
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
        //la creacion de esta lista se realizo con el fin de traer datos para el ejercicio
        let lbBatman : ComicDTO = {
            id: "1",
            nombre: "Batman Inicia",
            editorial: "DcComics",
            tematica: "AVENTURAS",
            numeroPaginas: 214,
            precio: 52.400,
            autores: "Bob kane",
            color: true,
            coleccion: "oro",
            fechaVenta: new Date("2017-05-21"),
            estado: "Activo",
            cantidad: 12 
          };
      
          let lbIronMan : ComicDTO = {
            id: "2",
            nombre: "IronMan y el guantelete del infinito",
            editorial: "Marvel Comics",
            tematica: "AVENTURAS",
            numeroPaginas: 324,
            precio: 72.400,
            autores: "Larry Lieber",
            color: true,
            coleccion: "oro",
            fechaVenta: new Date("2017-05-21"),
            estado: "Activo",
            cantidad: 12 
          };
      
          let lbSuperMan : ComicDTO = {
            id: "3",
            nombre: "Superman el hombre de acero",
            editorial: "DcComics",
            tematica: "AVENTURAS",
            numeroPaginas: 624,
            precio: 102.400,
            autores: "Jerry Siegel",
            color: true,
            coleccion: "oro",
            fechaVenta: new Date("2017-05-21"),
            estado: "Activo",
            cantidad: 12 
          };
      
          let lbCapitanAmerica : ComicDTO = {
            id: "4",
            nombre: "Capitan America el primer Vengador",
            editorial: "Marvel Comics",
            tematica: "AVENTURAS",
            numeroPaginas: 714,
            precio: 91.400,
            autores: "Joe Simon",
            color: false,
            coleccion: "oro",
            fechaVenta: new Date("2017-05-21"),
            estado: "Activo",
            cantidad: 12 
          };
      
          let lbDragonBall : ComicDTO = {
            id: "5",
            nombre: "Goku el legendario guerrero Sayayin",
            editorial: "Weekly Shōnen Jump",
            tematica: "AVENTURAS",
            numeroPaginas: 114,
            precio: 63.400,
            autores: "Akira Toriyama",
            color: false,
            coleccion: "oro",
            fechaVenta: new Date("2017-05-21"),
            estado: "Activo",
            cantidad: 12 
          };
      
          let lbOnePiece : ComicDTO = {
            id: "6",
            nombre: "Luffy el proximo rey de los piratas",
            editorial: "Weekly Shōnen Jump",
            tematica: "AVENTURAS",
            numeroPaginas: 314,
            precio: 524.100,
            autores: "Eiichiro Oda",
            color: false,
            coleccion: "oro",
            fechaVenta: new Date("2017-05-21"),
            estado: "Activo",
            cantidad: 12 
          };
      
          this.listaComics.push(lbBatman);
          this.listaComics.push(lbIronMan);
          this.listaComics.push(lbSuperMan);
          this.listaComics.push(lbCapitanAmerica);
          this.listaComics.push(lbDragonBall);
          this.listaComics.push(lbOnePiece);        
          
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
        this.idComic++;
        this.comic = new ComicDTO();
        this.comic.id = this.idComic + "";
        this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
        this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
        this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
        this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
        this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
        this.comic.precio = this.gestionarComicForm.controls.precio.value;
        this.comic.autores = this.gestionarComicForm.controls.autores.value;
        this.comic.color = this.gestionarComicForm.controls.color.value;
        
        this.listaComics.push(this.comic);
        this.limpiarFormulario();   
        this.createName= this.comic.nombre;
    }

    /**
     * @description Metodo que se encarga por medio de una posicion de permitir
     * al usuario modificar el campo que desee del comic
     * @author Laura Elizabeth Castellanos Ducon
     */
    public editarComic(posicion:number) : void {
        this.editar=true;
        //mostrara la informacion que contiene el comic
        this.gestionarComicForm.controls.nombre.setValue(this.listaComics[posicion-1].nombre);
        this.gestionarComicForm.controls.editorial.setValue(this.listaComics[posicion-1].editorial);
        this.gestionarComicForm.controls.tematica.setValue(this.listaComics[posicion-1].tematica);
        this.gestionarComicForm.controls.coleccion.setValue(this.listaComics[posicion-1].coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(this.listaComics[posicion-1].numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(this.listaComics[posicion-1].precio);
        this.gestionarComicForm.controls.autores.setValue(this.listaComics[posicion-1].autores);
        this.gestionarComicForm.controls.color.setValue(this.listaComics[posicion-1].color);
        this.deletePosition(posicion);
    }

     /**
     * @description Metodo que se encarga de dejar en blanco el formulario
     * @author Laura Elizabeth Castellanos Ducon
     */
    private limpiarFormulario() : void {
        this.submitted = false;
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
     */
  public deletePosition(posicion:number): void{
    this.error=false;
    this.flagC=false;
    this.flag=true;
    console.log("Esta entrando");

    for (let i = 0; i < this.listaComics.length; i++) {
      const element = this.listaComics[i];
      console.log(element.id);
    }try {
      this.deleteName= this.listaComics[posicion-1].nombre;
      //el splice se encargara de eliminar la posicion que ingresa por parametro
      this.listaComics.splice(posicion-1,1);   
      let n: number;
      n = window.setTimeout(function () { this.flag=false  }, 5000);
    } catch (e) {
      this.error=true;
      if(e instanceof Error) {
        this.msgError = "No encontrar la direccion solicitada por el usuario";
      }
    }
  }
}