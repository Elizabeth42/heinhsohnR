package com.hbt.semillero.ejb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.entidad.EstadoEnum;
import com.hbt.semillero.entidad.Persona;
import com.hbt.semillero.entidad.Proveedor;
/**
 * Clase que determina el bean para realizar la gestion de los proveedores
 * @author Laura Elizabeth Castellanos Ducon
 *
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarProveedorBean implements IGestionarProveedor {

	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;
	/**
	 * Este metodo retorna un booleano que hara referencia a la creacion 
	 * exitosa o fallida del proveedor, si la creacion fue exitosa realizara la 
	 * operacion, si por el contrario no cumple la condicion no permitira la creacion
	 * del proveedor
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public boolean crearProveedor(ProveedorDTO proveedorNuevo, Long idPersona) {
		Proveedor proveedor = new Proveedor();
		LocalDate ahora = LocalDate.now();
		boolean flag = false;
		/*
		 * El if permite validar que la direccion que se esta ingresando sea unica
		 * ademas permite analizar que haya menos de 30 proveedores registrados
		 */
		if (isUnique(proveedorNuevo.getDireccionProveedor())==true && cantProveedor()<30L) {
			proveedor.setIdProveedor(proveedorNuevo.getIdProveedor());
			proveedor.setDireccionProveedor(proveedorNuevo.getDireccionProveedor());
			// esta validacion se realiza para garantizar que la fecha ingresada no es mayor a la fecha actual
			if (proveedorNuevo.getFecha_creacion().isAfter(ahora)) {
				return flag;
			}
			proveedor.setFecha_creacion(proveedorNuevo.getFecha_creacion());
			proveedor.setEstado(EstadoEnum.ACTIVO);
			proveedor.setPersona(em.find(Persona.class, idPersona));
			proveedor.setMonto(20000000L); // se crea con un monto fijo
			flag = true;
			em.persist(proveedor);
		}
		return flag;
			
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public String modificarProveedor(Long id, Long montoNuevo) {
		Proveedor proveedorModificar;
		String message = new String();
		proveedorModificar = em.find(Proveedor.class, id);
		if (montoNuevo <=15000000L) {
			message ="Peligro el monto esta cerca a coparse";
		}else {
			message = "Monto aun dentro de elos limites";
		}
		proveedorModificar.setMonto(montoNuevo);
		em.merge(proveedorModificar);	
		return message;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarProveedor(Long id) {
		Proveedor proveedorEliminar;
		proveedorEliminar = em.find(Proveedor.class, id);
		proveedorEliminar.setEstado(EstadoEnum.INACTIVO);
		em.merge(proveedorEliminar);
		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ProveedorDTO consultarProveedor(Long idProveedor) {
		Proveedor proveedor = new Proveedor();
		proveedor = em.find(Proveedor.class, idProveedor);
		ProveedorDTO proveedorDTO = convertirProveedorToProveedorDTO(proveedor);
		return proveedorDTO;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ProveedorDTO> consultarProveedores() {
		List <ProveedorDTO> resultadosProveedorDTO = new ArrayList<ProveedorDTO>();
		List<Proveedor> resultados  = em.createQuery("select p from Proveedor p").getResultList();
		for (Proveedor proveedor : resultados) {
			resultadosProveedorDTO.add(convertirProveedorToProveedorDTO(proveedor));
		}
		return resultadosProveedorDTO;
	}

	/** 
	 * Metodo encargado de transformar la entidad proveedor  a proveedorDTO
	 * 
	 * @param proveedor
	 * @return
	 */
	private ProveedorDTO convertirProveedorToProveedorDTO(Proveedor proveedor) {
		ProveedorDTO proveedorDTO = new ProveedorDTO();
		if(proveedor.getIdProveedor()!=null) {
			proveedorDTO.setIdProveedor(proveedor.getIdProveedor());
		}
		proveedorDTO.setDireccionProveedor(proveedor.getDireccionProveedor());
		proveedorDTO.setFecha_creacion(proveedor.getFecha_creacion());
		proveedorDTO.setEstado(proveedor.getEstado());
		proveedorDTO.setPersona(proveedor.getPersona());
		proveedorDTO.setMonto(proveedor.getMonto());
		return proveedorDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar un proveedorDTO a una endidad proveedor
	 * 
	 * @param personaDTO
	 * @return
	 */
	private Proveedor convertirProveedorDTOToProveedor(ProveedorDTO proveedorDTO) {
		Proveedor proveedor = new Proveedor();
		if(proveedorDTO.getIdProveedor()!=null) {
			proveedor.setIdProveedor(proveedorDTO.getIdProveedor());
		}
		proveedor.setDireccionProveedor(proveedorDTO.getDireccionProveedor());
		proveedor.setFecha_creacion(proveedorDTO.getFecha_creacion());
		proveedor.setEstado(proveedorDTO.getEstado());
		proveedor.setPersona(proveedorDTO.getPersona());
		proveedor.setMonto(proveedorDTO.getMonto());
		return proveedor;
	}
	
	/**
	 * permitira verificar si la direccion de un proveedor es unica
	 * true: si es unico
	 * false: no es unico
	 * @param address
	 */
	public boolean isUnique(String address) {
		//verificara si hay algun usuario con ese nombre
		List<Proveedor> proveedores = em.createQuery("Select p from Proveedor p  where p.direccionProveedor=:address").setParameter("address", address).getResultList();
		return proveedores.size()==0;
	}
	
	/**
	 * permitira establecer la cantidad de proveedores que tiene actualmente el sistema
	 */
	public Long cantProveedor () {
		Long cant = 0L;
		cant = (Long) em.createQuery("select COUNT(p) from Proveedor p").getSingleResult();
		return cant;
	}
	/**
	 * Permite validar si el contrato se encuentra vigente con el proveedor
	 * Recordar que esto parte de la fecha de creacion del contrato
	 */
//	public boolean isVigent(Long idProveedor) {
//		boolean flag = false;
//		Proveedor proveedor = new Proveedor();
//		LocalDate ahora = LocalDate.now();
//		proveedor = em.find(Proveedor.class, idProveedor);
//		LocalDate resta =  proveedor.getFecha_creacion().minusYears(1);
//		if (resta) {
//			
//		}
//		return flag;
//	}
}
