/**
 * GestionarComicPOJO.java
 */
package com.hbt.semillero.pojo;

import java.util.List;
import com.hbt.semillero.dto.ComicDTO;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Usuario
 * @version 
 */
public class GestionarComicPOJO {

	private List<ComicDTO> listaComics = null;

	/**
	 * busca crear un nuevo comic
	 * y adicionarla a la lista que ya tenemos
	 */
	//TODO CONTINUAR LLENANDO EL COMIC DTO
	public void crearComicDTO() {
		ComicDTO comicDTO = new ComicDTO();
		
	}
	/**
	 * Metodo encargado de retornar el valor del atributo listaComics
	 * @return El listaComics asociado a la clase
	 */
	public List<ComicDTO> getListaComics() {
		return listaComics;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComics
	 * @param listaComics El nuevo listaComics a modificar.
	 */
	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	}
	
}
