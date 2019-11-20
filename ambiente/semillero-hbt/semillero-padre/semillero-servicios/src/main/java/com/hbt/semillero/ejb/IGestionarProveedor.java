package com.hbt.semillero.ejb;

import java.util.List;

import com.hbt.semillero.dto.ProveedorDTO;

/**
 * Aca se estipulan los metodos necesarios para el manejo del proveedor en el sistema
 * @author Usuario
 *
 */
public interface IGestionarProveedor {	/**
	 * Metodo encargado de crear un proveedor nuevo y persistirlo
	 * @param proveedorusuarioNuevo
	 */
	public boolean crearProveedor (ProveedorDTO proveedorNuevo);
	/**
	 * Metodo encargado de modificar el nombre del usuario
	 * @param id
	 * @param nombre
	 */
	public String modificarProveedor(Long id, Long monto);
	/**
	 * Metodo encargado de eliminar proveedor
	 * En este caso es mas una modificacion del esttado
	 * @param id
	 */
	public void eliminarProveedor(Long id);
	/**
	 * Se encargara de la busqueda de un proveedor
	 * @param idUsuario
	 * @return
	 */
	public ProveedorDTO consultarProveedor (Long idProveedor);
	/**
	 * se encarga de retornar la lista de los proveedores creados
	 * @return
	 */
	public List<ProveedorDTO> consultarProveedores();
}