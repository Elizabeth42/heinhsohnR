/**
 * GestionarComicPOJO.java
 */
package com.hbt.semillero.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Laura Elizabeth Castellanos Ducon
 * @version 
 */
public class GestionarComicPOJO {

	private List<ComicDTO> listaComics = null;

	public ComicDTO crearComicDTO(String id,String nombre, String editorial, TematicaEnum tematica, String coleccion, Integer numeroPaginas,
			BigDecimal precio, String autores, Boolean color, LocalDate fechaVenta, EstadoEnum estado, Long cantidad) {
		ComicDTO comicDTO = new ComicDTO(id, nombre, editorial, tematica, coleccion, numeroPaginas, precio, autores, color, fechaVenta, estado, cantidad);
		return comicDTO;
	}

	/**
	 * busca crear un nuevo comic
	 * y adicionarla a la lista que ya tenemos
	 */
	//TODO CONTINUAR LLENANDO EL COMIC DTO
	public void crearComicDTO() {
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setId("100");
		comicDTO.setNombre("Dragon Ball Yamcha");
		comicDTO.setEditorial("Planeta Comic");
		comicDTO.setTematica(TematicaEnum.AVENTURAS);
		comicDTO.setColeccion("Manga Shonen");
		comicDTO.setPrecio(new BigDecimal (2100));
		comicDTO.setAutores("Dragon Garow Lee");
		comicDTO.setColor(Boolean.FALSE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstado(EstadoEnum.ACTIVO);
		comicDTO.setCantidad(20L);
		if(listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();
		}
		listaComics.add(comicDTO);
	}
		
	public void agregarComicDTOLista(ComicDTO comicDTO) {
		if(listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();
		}
		listaComics.add(comicDTO);
	}
	
	public void modificarComicDTO(int i, ComicDTO comicDTO) {
		listaComics.set(i, comicDTO);	
	}
	/**
	 * Por medio del id se obtiene el campo que se desea modificar
	 * y de igual manera se envia el nuevo valor a almacenar
	 * */
	public void modificarComicDTO(String id, String nombreModificar) {
		ComicDTO comicAModificar = null;
		for (int i = 0; i < listaComics.size(); i++) {
			comicAModificar =listaComics.get(i);
			if(listaComics.get(i).getId().equals(id)) {
				listaComics.get(i).setNombre(nombreModificar);
				return;
			}
		}
	}
	/**
	 * se crea una nueva forma de agregar, en la cual se le pueda especificar
	 * la lista a la cual se agregara el comic
	 * */
	public void agregarComicDTOLista(ComicDTO comicDTO, List list) {
		
		if(list == null) {
			list = new ArrayList<ComicDTO>();
		}
		list.add(comicDTO);
	}
	
	/**
	 * por medio del id se obtiene el campo que se desea eliminar
	 * */
	public void deleteComicDTO(String id) {
		List<ComicDTO> listaTemporal = new ArrayList<ComicDTO>();
		ComicDTO comicTemporal = null;
		int i =0;
		while(i < listaComics.size()) {
			comicTemporal = listaComics.get(i);
			if (!listaComics.get(i).getId().equals(id)) {
//				System.out.println(comicTemporal.getNombre() + " "+ listaTemporal.get(i)+listaTemporal.get(i).getNombre());
				agregarComicDTOLista(comicTemporal,listaTemporal);
			}
			i++;
		}
		listaComics = listaTemporal;		
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
