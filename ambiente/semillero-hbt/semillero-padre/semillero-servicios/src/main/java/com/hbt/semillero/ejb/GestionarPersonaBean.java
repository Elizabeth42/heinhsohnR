package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.entidad.Persona;
/**
 * Clase que determina el bean para realizar las gestion de las personas
 * @author Laura Elizabeth Castellanos Ducon
 *
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarPersonaBean implements IGestionarPersona {

	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public boolean crearPersona(PersonaDTO personaNueva) {
		boolean flag = false;
		Persona persona = new Persona();
		/*
		 * permitira realizar la validacion de nombre unico
		 * en caso de no cumplirla el usuario no sera creado y refornara un false
		 */
		if (isUnique(personaNueva.getNombre())) {
			persona.setNombre(personaNueva.getNombre());
			persona.setId(personaNueva.getIdPersona());
			persona.setNumIdentificacion(personaNueva.getNumIdentificacion());
			flag = true;
			em.persist(persona);
		}
			return flag;	
	}
	
	@Override
	public boolean modificarPersona(Long id, String nombre) {
		Persona personaModificar;
		boolean flag = false;
		personaModificar = em.find(Persona.class, id);
		if (isUnique(nombre)) {
			personaModificar.setNombre(nombre);
			em.merge(personaModificar);
			flag = true;
		}
		return flag;
	}

//
//	@Override
//	public void eliminarPersona(Long id) {
//		Persona personaEliminar ;
//		personaEliminar = em.find(Persona.class, id);
//		personaEliminar.set
//		em.merge(personaModificar);			
//	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public PersonaDTO consultarPersona(Long idPersona) {
		Persona persona = new Persona();
		persona = em.find(Persona.class, idPersona);
		PersonaDTO personaDTO = convertirPersonaToPersonaDTO(persona);
		return personaDTO;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<PersonaDTO> consultarPersonas() {
		List<PersonaDTO> resultadosPersonaDTO = new ArrayList<PersonaDTO>();
		List<Persona> resultados = em.createQuery("select p from Persona p").getResultList();
		for (Persona persona : resultados) {
			resultadosPersonaDTO.add(convertirPersonaToPersonaDTO(persona));
		}
		return resultadosPersonaDTO;
	}
	
	/** 
	 * Metodo encargado de transformar la entidad persona  a personaDTO
	 * 
	 * @param persona
	 * @return
	 */
	private PersonaDTO convertirPersonaToPersonaDTO(Persona persona) {
		PersonaDTO personaDTO = new PersonaDTO();
		if(persona.getId()!=null) {
		 personaDTO.setIdPersona(persona.getId());
		}
		personaDTO.setNombre(persona.getNombre());
		personaDTO.setNumIdentificacion(persona.getNumIdentificacion());
		return personaDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar un personaDTO a una endidad persona
	 * 
	 * @param personaDTO
	 * @return
	 */
	private Persona convertirPersonaDTOToPersona(PersonaDTO personaDTO) {
		Persona persona = new Persona();
		if(personaDTO.getIdPersona()!=null) {
			persona.setId(personaDTO.getIdPersona());
		}
		persona.setNombre(personaDTO.getNombre());
		persona.setNumIdentificacion(personaDTO.getNumIdentificacion());
		return persona;
	}

	/**
	 * permitira verificar si el nombre de una persona es unico
	 * true: si es unico
	 * false: no es unico
	 */
	public boolean isUnique(String name) {
		//verificara si hay algun usuario con ese nombre
		List<Persona> personas = em.createQuery("Select p from Persona p  where p.nombre=:name").setParameter("name", name).getResultList();
		return personas.size()==0;
	}

	
}
