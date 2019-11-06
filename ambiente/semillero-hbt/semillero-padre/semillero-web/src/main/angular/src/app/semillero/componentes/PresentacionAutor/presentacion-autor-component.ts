import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LibroDTO } from '../../dto/libro.dto';
/**
 * @description: Esta clase sirve para crear los diferentes libros (comics)
 * @author: Laura Elizabeth Castellanos Ducon
 */
@Component({
    selector: 'presentacion-component',
    templateUrl: './presentacion-autor-component.html'
  })
export class PresentacionAutorComponent implements OnInit {

  public listaLibros : Array<LibroDTO> = new Array<LibroDTO>();
  public flag:boolean;
  public deleteName: string;
  public error: boolean;
  public msgError:string;
  
  ngOnInit(): void {
  let lbBatman : LibroDTO = {
      id : 1,
      nombre: "Batman Inicia",
      editorial: "DcComics",
      numeroPaginas: 214,
      precio: 52.400,
      autores: "Bob kane",
      aColor: true,
      fechaVenta: new Date("2019-01-16"),
      estado: "Activo"
    };

    let lbIronMan : LibroDTO = {
      id : 2,
      nombre: "IronMan y el guantelete del infinito",
      editorial: "Marvel Comics",
      numeroPaginas: 324,
      precio: 72.400,
      autores: "Larry Lieber",
      aColor: true,
      fechaVenta: new Date("2017-05-21"),
      estado: "Activo"
    };

    let lbSuperMan : LibroDTO = {
      id : 3,
      nombre: "Superman el hombre de acero",
      editorial: "DcComics",
      numeroPaginas: 624,
      precio: 102.400,
      autores: "Jerry Siegel",
      aColor: true,
      fechaVenta: new Date("1993-05-21"),
      estado: "Activo"
    };

    let lbCapitanAmerica : LibroDTO = {
      id : 4,
      nombre: "Capitan America el primer Vengador",
      editorial: "Marvel Comics",
      numeroPaginas: 714,
      precio: 91.400,
      autores: "Joe Simon",
      aColor: false,
      fechaVenta: new Date("2000-04-07"),
      estado: "Inactivo"
    };

    let lbDragonBall : LibroDTO = {
      id : 5,
      nombre: "Goku el legendario guerrero Sayayin",
      editorial: "Weekly Shōnen Jump",
      numeroPaginas: 114,
      precio: 63.400,
      autores: "Akira Toriyama",
      aColor: false,
      fechaVenta: new Date("1995-02-03"),
      estado: "Activo"
    };

    let lbOnePiece : LibroDTO = {
      id : 6,
      nombre: "Luffy el proximo rey de los piratas",
      editorial: "Weekly Shōnen Jump",
      numeroPaginas: 314,
      precio: 524.100,
      autores: "Eiichiro Oda",
      aColor: false,
      fechaVenta: new Date("1999-01-03"),
      estado: "Inactivo"
    };

    this.listaLibros.push(lbBatman);
    this.listaLibros.push(lbIronMan);
    this.listaLibros.push(lbSuperMan);
    this.listaLibros.push(lbCapitanAmerica);
    this.listaLibros.push(lbDragonBall);
    this.listaLibros.push(lbOnePiece);
    
    }

    /**
     * Este metodo permite ingresar por parametro la posicion a eliminar 
     */
  public deletePosition(posicion:number): void{
    this.error=false;
    this.flag=true;
    console.log("Esta entrando");

    for (let i = 0; i < this.listaLibros.length; i++) {
      const element = this.listaLibros[i];
      console.log(element.id);
    }try {
      this.deleteName= this.listaLibros[posicion-1].nombre;
      //el splice se encargara de eliminar la posicion que ingresa por parametro
      this.listaLibros.splice(posicion-1,1);   
    } catch (e) {
      this.error=true;
      if(e instanceof Error) {
        this.msgError = "No encontrar la direccion solicitada por el usuario";
      }
    }
    console.log("-------------------------");
    for (let i = 0; i < this.listaLibros.length; i++) {
      const element = this.listaLibros[i];
      console.log(element.id);
    }
  }

  /**
   * Este metodo se utilizara para limpiar la variable de el libro eliminado
   */
  public clear():void{
    this.deleteName="";
    this.error=false;
    this.msgError="";
    this.flag= false;
  }
}