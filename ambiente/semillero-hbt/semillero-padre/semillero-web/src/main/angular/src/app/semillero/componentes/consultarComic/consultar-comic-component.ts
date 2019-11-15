import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

/**
 * @description Componenete consultar comic, el cual contiene la cpnsulta de la informacion al CRUD
 * 
 * @author Laura Elizabeth Castellanos Ducon <eliizabeth.42@gmail.com>
 */
@Component({
    selector: 'consultar-comic',
    templateUrl: './consultar-comic-component.html'
})
export class ConsultarComicComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public consultarComicForm : FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaComics : Array<ComicDTO>;

  
    
    /**
     * @description Este es el constructor del componente ConsultarComicComponent
     * @author Laura Elizabeth Castellanos Ducon <eliizabeth.42@gmail.com.co>
     */
    constructor(private fb : FormBuilder,private router : Router, private activatedRoute: ActivatedRoute) {
        this.consultarComicForm = this.fb.group({
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
        let data = this.activatedRoute.snapshot.params;
        console.log(data);
        this.consultarComicForm.controls.nombre.setValue(data.nombre);
        this.consultarComicForm.controls.editorial.setValue(data.editorial);
        this.consultarComicForm.controls.tematica.setValue(data.tematica);
        this.consultarComicForm.controls.coleccion.setValue(data.coleccion);
        this.consultarComicForm.controls.numeroPaginas.setValue(data.numeroPaginas);
        this.consultarComicForm.controls.precio.setValue(data.precio);
        this.consultarComicForm.controls.autores.setValue(data.autores);
        this.consultarComicForm.controls.color.setValue(data.color);
        this.consultarComicForm.controls.nombre.disable();
        this.consultarComicForm.controls.editorial.disable();
        this.consultarComicForm.controls.tematica.disable();
        this.consultarComicForm.controls.coleccion.disable();
        this.consultarComicForm.controls.numeroPaginas.disable();
        this.consultarComicForm.controls.precio.disable();
        this.consultarComicForm.controls.autores.disable();
        this.consultarComicForm.controls.color.disable();
    }


    /**
     * Metodo que permite retornar a la pagina de gesstionar comic
     */
    public retornar() : void {
        this.router.navigate(['gestionar-comic']);
    }


}