/**
 * @description Clase ProveedorDTO que contiene la informacion de un proveedor
 * 
 * @author Laura Elizabeth Castellanos Ducon
 */
export class ProveedorDTO {

    /**
    * identificador del proveedor
    */
    public idProveedor: number;

    /**
    * direccion del proveedor
    */
    public direccion: string;

    /**
    * fecha de creacion del proveedor
    */
    public fechaCreacion: Date;

    /**
     * Estado del proveedor
     */
    public estado:string;

    /**
     * hace referencia a la persona asociada al proveedor
     */
    public proveedor: ProveedorDTO;

}
  