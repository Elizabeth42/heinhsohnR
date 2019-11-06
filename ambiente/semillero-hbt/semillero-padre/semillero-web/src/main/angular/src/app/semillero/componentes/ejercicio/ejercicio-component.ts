import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

/**
 * @description Componente para solucion de ejercicios
 * 
 * @author Laura Elizabeth Castellanos Ducon
 */
@Component({
  selector: 'ejercicio-component',
  templateUrl: './ejercicio-component.html',
})
export class EjercicioComponent implements OnInit {

    public variableComparar: Number;
    public listaNombres : Array<any> = new Array<any>();
    public resultado:string;

    ngOnInit(): void {
        this.variableComparar= 2453;
        let objeto1 : any = {
            id : 1,
            nombre : "juan",
        };
        let objeto2 : any = {
            id : 2,
            nombre : "jose",
        };
        let objeto3 : any = {
            id : 3,
            nombre : "pedro",
        };
        let objeto4 : any = {
            id : 4,
            nombre : "luisa",
        };
        let objeto5 : any = {
            id : 5,
            nombre : "ximena",
        };
       this.listaNombres.push(objeto1);
       this.listaNombres.push(objeto2);
       this.listaNombres.push(objeto3);
       this.listaNombres.push(objeto4);
       this.listaNombres.push(objeto5);
    }

    public compare():void{
  //      if(this.variableComparar=="2453"){
    //        console.log("Teoricamente el resultado es positivo por la cantidad de = en la expresion");
      //  }
      for (let i = 0; i < this.listaNombres.length; i++) {
          const element = this.listaNombres[i];
            if (element.id=="5") {
                this.resultado="Se simboliza de la misma manera pero el tipo de dato es distinto";
            }
      }
    }

    /**metodo para eliminar un elemento de una lista
     * 
     */
    public delete(borrar:number):void{
        this.listaNombres.splice(borrar-1,1);
    }

}
