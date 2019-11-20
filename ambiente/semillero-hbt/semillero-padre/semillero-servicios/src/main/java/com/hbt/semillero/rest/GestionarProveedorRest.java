package com.hbt.semillero.rest;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarProveedor;
import com.hbt.semillero.entidad.Proveedor;

/**
 * Clase para determinar los servicios rest de gestionar un proveedor
 * @author Laura Elizabeth Castellanos Ducon
 *
 */
@Path("/GestionarProveedor")
public class GestionarProveedorRest {
	
	/**
	 * Atriburo que permite gestionar una persona
	 */
	@EJB
	private IGestionarProveedor gestionarProveedorEJB;
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de todas los proveedores
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/consultarProveedores
	 * 
	 * @return
	 */
	@GET
	@Path("/consultarProveedores")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProveedorDTO> consultarProveedores() {
		return gestionarProveedorEJB.consultarProveedores();
	}
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de un proveedor determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/consultarProveedor?idProveedor=1
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/consultarProveedor/1 <- pathParam
	 * @param idProveedor
	 * @return
	 */
	@GET
	@Path("/consultarProveedor")
	@Produces(MediaType.APPLICATION_JSON)
	public ProveedorDTO consultarProveedor(@QueryParam("idProveedor") Long idProveedor) {
		if (idProveedor != null) {
			ProveedorDTO proveedorDTO = gestionarProveedorEJB.consultarProveedor(idProveedor);
			return proveedorDTO;
		}
		return null;
	}
	
	/**
	 * Crea los proveedores en sus diferentes roles dentro del sistema.
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/crear
	 * @param proveedor
	 * @return
	 */
	@POST
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearProveedor(ProveedorDTO proveedornuevo, Long idPersona) {
		ProveedorDTO p1 = new 	ProveedorDTO();
		p1.setDireccionProveedor("Cra 23 # 12-30 Fuente");
		LocalDate localDateOf = LocalDate.of(2017, 10, 10); 
		p1.setFecha_creacion(localDateOf);
		gestionarProveedorEJB.crearProveedor(p1,1L);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Proveedor creado exitosamente");
		return resultadoDTO;
	}
	
	/**
	 * 
	 * Metodo encargado de modificar el monto de un proveedor
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/modificar?idProveedor=1&montoNuevo=16245000
	 * @param idProveedor identificador del proveedor a buscar
	 * @param montoNuevo monto nuevo del proveedor
	 */
	@POST
	@Path("/modificar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO modificarProveedor(Long idProveedor, Long montoNuevo) {
		ResultadoDTO resultadoMsg;	
		try {		
			if (idProveedor != null) {
				gestionarProveedorEJB.modificarProveedor(idProveedor, montoNuevo);
				resultadoMsg = new ResultadoDTO(true, "Modificacion exitosa");
			}else {
				resultadoMsg = new ResultadoDTO(false, "No existe el objeto a modificar");				
			}
		} catch (Exception e) {
			resultadoMsg = new ResultadoDTO(false, "Problemas al modificar: "+e.getMessage());
		}
		return resultadoMsg;
	}
	
	/**
	 * 
	 * Metodo encargado de eliminar un proveedor
	 * Recordar que cuando decimos eliminar hacemos referencia a modificar el estado de Activo a Inactivo
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/eliminar?idProveedor=1
	 * @param idProveedor identificador del proveedor a buscar
	 */
	@POST
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO eliminarProveedor(Long idProveedor) {
		ResultadoDTO resultadoMsg;	
		try {		
			if (idProveedor != null) {
				gestionarProveedorEJB.eliminarProveedor(idProveedor);
				resultadoMsg = new ResultadoDTO(true, "Modificacion exitosa");
			}else {
				resultadoMsg = new ResultadoDTO(false, "No existe el objeto a modificar");				
			}
		} catch (Exception e) {
			resultadoMsg = new ResultadoDTO(false, "Problemas al modificar: "+e.getMessage());
		}
		return resultadoMsg;
	}
}
