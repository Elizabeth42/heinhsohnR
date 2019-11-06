/**
 * @description Clase LibroDTO contiene la informacion perteneciente
 * al segundo taller de la clase de angular
 * 
 * @author Laura Elizabeth Castellanos Ducon <eliizabeth.42@gmail.com>
 */

export class LibroDTO {
    /**
     * sera el identificador del libro
     */
    public id: number;
    /**
     * sera el nombre del libro
     */
    public nombre: string;
    /**
     * hace referencia a la editorial
     */
    public editorial: string;
    /**
     * es la cantidad de paginas que tendra el libro
     */
    public numeroPaginas: number;
    /**
     * es el precio al que hace referencia el libro
     */
    public precio: number;
    /**
     * son el o los autores del libro
     */
    public autores: string;
    /**
     * sera si el libro es a color o a blanco y negro
     */
    public aColor: boolean;
    /**
     * es la fecha en la cual se realizo la venta
     */
    public fechaVenta: Date;
    /**
     *  hace referencia a si se encuentra activo o no
     */
    public estado: string;
}