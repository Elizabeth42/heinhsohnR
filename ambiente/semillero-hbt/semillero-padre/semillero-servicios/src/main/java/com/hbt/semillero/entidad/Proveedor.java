package com.hbt.semillero.entidad;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * Descripción: Clase que determina la entidad que permite representar la
 * tabla "DB_SEMILLERO"."TC_PROVEEDOR"
 * 
 * @author Laura Elizabeth Castellanos Ducon
 * @version
 */
@Entity
@Table(name = "TC_PROVEEDOR")
public class Proveedor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * identificador unico del proveedor
	 * */
	@Id
	@SequenceGenerator(allocationSize = 1, name = "PROVEEDOR_SPID_GENERATOR", sequenceName = "SEQ_PROVEEDOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROVEEDOR_SPID_GENERATOR")
	@Column(name = "SPID")
	private Long idProveedor;
	/**
	 * direccion del proveedor
	 * */
	@Column(name = "SPDIRECCION")
	private String direccionProveedor;
	/**
	 * fecha de creacion del nuevo proveedor
	 * */
	@Column(name = "SPFECHA_CREACION")
	private  LocalDate fecha_creacion;
	/**
	 * Es el estado del proveedor
	 * */
	@Column(name = "SPESTADO")
	@Enumerated(value = EnumType.STRING)
	private  EstadoEnum estado;
	/**
	 * Identificador unico de la persona
	 * */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SPIDPERSONA")
	private Persona persona;

	/**
	 * Sera el monto de credito
	 * */
	@Column(name = "SPMONTO_CREDITO")
	private Long monto;
	/**
	 * constructor de la clase
	 * */
	public Proveedor() {
		
	}

	//SETTERS Y GETTERS
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	public Long getIdProveedor() {
		return idProveedor;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * 
	 * @param id El nuevo id a modificar.
	 */
	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo direccion
	 * 
	 * @return La direccion asociada a la clase
	 */
	public String getDireccionProveedor() {
		return direccionProveedor;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo direccion
	 * 
	 * @param nombre La nueva  direccion a modificar.
	 */
	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo fecha creacion
	 * 
	 * @return La fecha de creacion asociado a la clase
	 */
	public LocalDate getFecha_creacion() {
		return fecha_creacion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo fecha creacion
	 * 
	 * @param fecha creacion, la nueva fecha de creacion a modificar.
	 */
	public void setFecha_creacion(LocalDate fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * 
	 * @return El estado asociado a la clase
	 */
	public EstadoEnum getEstado() {
		return estado;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * 
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	/**
	 * Metodo encargado de retornar el valor del monto credito
	 * 
	 * @return El cantidad asociado a la clase
	 */
	public Long getMonto() {
		return monto;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo monto credito
	 * 
	 * @param monto El nuevo monto a modificar.
	 */
	public void setMonto(Long monto) {
		this.monto = monto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccionProveedor == null) ? 0 : direccionProveedor.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fecha_creacion == null) ? 0 : fecha_creacion.hashCode());
		result = prime * result + ((idProveedor == null) ? 0 : idProveedor.hashCode());
		result = prime * result + ((monto == null) ? 0 : monto.hashCode());
		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proveedor other = (Proveedor) obj;
		if (direccionProveedor == null) {
			if (other.direccionProveedor != null)
				return false;
		} else if (!direccionProveedor.equals(other.direccionProveedor))
			return false;
		if (estado != other.estado)
			return false;
		if (fecha_creacion == null) {
			if (other.fecha_creacion != null)
				return false;
		} else if (!fecha_creacion.equals(other.fecha_creacion))
			return false;
		if (idProveedor == null) {
			if (other.idProveedor != null)
				return false;
		} else if (!idProveedor.equals(other.idProveedor))
			return false;
		if (monto == null) {
			if (other.monto != null)
				return false;
		} else if (!monto.equals(other.monto))
			return false;
		if (persona == null) {
			if (other.persona != null)
				return false;
		} else if (!persona.equals(other.persona))
			return false;
		return true;
	}
}
