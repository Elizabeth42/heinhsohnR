package com.hbt.semillero.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;

/**
 * 
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Usuario
 * @version
 */
public class ComicDTO implements Serializable{

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = -4578139839535238036L;
	/**
	 * Identificador del comic o revista grafica
	 * */
	private String id;
	/**
	 * Nombre del comic o revista grafica
	 * */
	private String nombre;
	/**
	 * 
	 * */
	private String editorial;
	/**
	 * 
	 **/
	private TematicaEnum tematicaEnum;
	/**
	 * 
	 * */
	private String coleccion;
	/**
	 * 
	 **/
	private Integer numeroPaginas;
	/**
	 * 
	 **/
	private BigDecimal precio;
	/**
	 * 
	 **/
	private String autores;
	/**
	 * 
	 **/
	private Boolean color;
	/**
	 * 
	 **/
	private LocalDate fechaVenta;
	/**
	 * 
	 **/
	private EstadoEnum estado;
	/**
	 * 
	 **/
	private Long cantidad;

	/**
	 * Constructor de la clase.
	 */
	public ComicDTO() {
		
	}

	
	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 * @param editorial
	 * @param tematica
	 * @param coleccion
	 * @param numeroPaginas
	 * @param precio
	 * @param autores
	 * @param color
	 * @param fechaVenta
	 * @param estado
	 * @param cantidad
	 */
	public ComicDTO(String id, String nombre, String editorial, TematicaEnum tematica, String coleccion,
			Integer numeroPaginas, BigDecimal precio, String autores, Boolean color, LocalDate fechaVenta,
			EstadoEnum estado, Long cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.editorial = editorial;
		this.tematicaEnum = tematica;
		this.coleccion = coleccion;
		this.numeroPaginas = numeroPaginas;
		this.precio = precio;
		this.autores = autores;
		this.color = color;
		this.fechaVenta = fechaVenta;
		this.estado = estado;
		this.cantidad = cantidad;
	}

	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 */
	public ComicDTO(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}


	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	public String getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo editorial
	 * @return El editorial asociado a la clase
	 */
	public String getEditorial() {
		return editorial;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo editorial
	 * @param editorial El nuevo editorial a modificar.
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo tematica
	 * @return El tematica asociado a la clase
	 */
	
	public TematicaEnum getTematica() {
		return tematicaEnum;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo tematica
	 * @param tematica El nuevo tematica a modificar.
	 */
	public void setTematica(TematicaEnum tematica) {
		this.tematicaEnum = tematica;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo coleccion
	 * @return El coleccion asociado a la clase
	 */
	public String getColeccion() {
		return coleccion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo coleccion
	 * @param coleccion El nuevo coleccion a modificar.
	 */
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo numeroPaginas
	 * @return El numeroPaginas asociado a la clase
	 */
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo numeroPaginas
	 * @param numeroPaginas El nuevo numeroPaginas a modificar.
	 */
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo precio
	 * @return El precio asociado a la clase
	 */
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo precio
	 * @param precio El nuevo precio a modificar.
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo autores
	 * @return El autores asociado a la clase
	 */
	public String getAutores() {
		return autores;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo autores
	 * @param autores El nuevo autores a modificar.
	 */
	public void setAutores(String autores) {
		this.autores = autores;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo color
	 * @return El color asociado a la clase
	 */
	public Boolean getColor() {
		return color;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo color
	 * @param color El nuevo color a modificar.
	 */
	public void setColor(Boolean color) {
		this.color = color;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo fechaVenta
	 * @return El fechaVenta asociado a la clase
	 */
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo fechaVenta
	 * @param fechaVenta El nuevo fechaVenta a modificar.
	 */
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * @return El estado asociado a la clase
	 */
	public EstadoEnum getEstado() {
		return estado;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo cantidad
	 * @return El cantidad asociado a la clase
	 */
	public Long getCantidad() {
		return cantidad;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo cantidad
	 * @param cantidad El nuevo cantidad a modificar.
	 */
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
}
