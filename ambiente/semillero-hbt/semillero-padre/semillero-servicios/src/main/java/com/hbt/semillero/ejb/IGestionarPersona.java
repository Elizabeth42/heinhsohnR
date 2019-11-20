package com.hbt.semillero.ejb;

import java.util.List;

import com.hbt.semillero.dto.PersonaDTO;

/**
 * Aca sera estipulado los metodos que son necesarios para la gestion 
 * de una persona en el sistema
 * @author Laura Elizabeth Castellanos Ducon
 *
 */
public interface IGestionarPersona {
/**
 * Metodo encargado de crear una persona y persistirla
 * @param personaNueva
 */
	public boolean crearPersona (PersonaDTO personaNueva);
	/**
	 * Metodo encargado de la modificacion del nombre de la persona
	 * @param id
	 * @param nombre
	 */
	public boolean modificarPersona(Long id, String nombre);
	/**
//	 * Metodo encargado de eliminar persona
//	 * @param id
//	 */
//	// ala hablar de eliminar en realidad es el cambio de estado
//	public void eliminarPersona(Long id);
//	
	/**
	 * Se encargara de la busqueda de una persona
	 * @param idPersona
	 * @return
	 */
	public PersonaDTO consultarPersona (Long idPersona);
	
	/**
	 * se encargara de retornar la lista de todods las personas registradas
	 */
	public List<PersonaDTO> consultarPersonas();
}
