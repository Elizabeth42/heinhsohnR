package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarPersona;

/**
 * Clase para determinar el servicio rest  que permite gestionar una persona
 * @author Laura Elizabeth Castellanos Ducon
 *
 */
@Path("/GestionarPersona")
public class GestionarPersonaRest {

	/**
	 * Atriburo que permite gestionar una persona
	 */
	@EJB
	private IGestionarPersona gestionarPersonaEJB;

	/**
	 * 
	 * Metodo encargado de traer la informacion de todas las personas
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersona/consultarPersonas
	 * 
	 * @return
	 */
	@GET
	@Path("/consultarPersonas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonaDTO> consultarPersonas() {
		return gestionarPersonaEJB.consultarPersonas();
	}
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de una persona determianda
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersona/consultarPersona?idPersona=1
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersona/consultarPersona/1 <- pathParam
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public PersonaDTO consultarPersona(@QueryParam("idPersona") Long idPersona) {
		if (idPersona != null) {
			PersonaDTO personaDTO = gestionarPersonaEJB.consultarPersona(idPersona);
			return personaDTO;
		}
		return null;
	}
	
	/**
	 * Crea las personas en sus diferentes roles dentro del sistema.
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersona/crear
	 * @param persona
	 * @return
	 */
	@POST
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearPersona(PersonaDTO personaDTO) {
//		PersonaDTO persona1 = new PersonaDTO();
//		persona1.setNombre("fransisco");
//		persona1.setNumIdentificacion(2436589L);
//		PersonaDTO persona2 = new PersonaDTO();
//		persona2.setNombre("David");
//		persona2.setNumIdentificacion(2312632L);
//		PersonaDTO persona3 = new PersonaDTO();
//		persona3.setNombre("lucy");
//		persona3.setNumIdentificacion(115044L);
//		PersonaDTO persona4 = new PersonaDTO();
//		persona4.setNombre("gabriela");
//		persona4.setNumIdentificacion(29711L);
//		gestionarPersonaEJB.crearPersona(persona1);
//		gestionarPersonaEJB.crearPersona(persona2);
//		gestionarPersonaEJB.crearPersona(persona3);
		gestionarPersonaEJB.crearPersona(personaDTO);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Persona creada exitosamente");
		return resultadoDTO;
	}
	
	/**
	 * 
	 * Metodo encargado de modificar el nombre de una persona
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersona/modificar?idPersona=1&nombre=nuevonombre
	 * @param idComic identificador del comic a buscar
	 * @param nombre nombre nuevo del comic
	 */
	@POST
	@Path("/modificar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO modificarPersona(PersonaDTO personaDTO) {
		ResultadoDTO resultadoMsg;	
		try {		
			if (personaDTO != null) {
				gestionarPersonaEJB.modificarPersona(personaDTO);
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
