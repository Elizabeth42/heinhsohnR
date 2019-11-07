package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;
/**
 * Para empezar la comunicacion entre la base de datos
 * y la aplicacion
 * */
@Stateless
public class GestionarComicBean implements IGestionarComicLocal {

	@PersistenceContext
    private EntityManager em;
	/*
	 * para que funcione bien necesitamos que entre un comicDTO
	 * debe guardar informacion en la base de datos
	 * REQUIRES_NEW pregunta si hay una transaccion activa, entonces crea una nueva
	 * y si no tiene una transaccion entonces crea una nueva
	 * */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearComic(ComicDTO comicDTO) {
		Comic comic = convertirComicDTOtoComic(comicDTO);
		em.persist(comic);
	}
	
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void modificarComic(ComicDTO comicModificar) {
		Comic comic = new Comic();
	//	comic.setId(comicModificar.getId());
		em.merge(comic);
	}
	/**
	 * 
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String id) {
		Comic comic = em.find(Comic.class,id);
		ComicDTO comicDTO = convertirComicToComicDTO(comic);
		return comicDTO;
	}
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarTodos(){
		em.createNativeQuery("SELECT c FROM Comic").getResultList();
		List<Comic> resultados = (List<Comic>) em.createQuery("select c from Comic").getResultList();
		return null;
	}
	/**
	 * Permitir modificar el nombre de un comic dado esto por medio de el id
	 * */
	@Override
	//@TransactionAttribute(TransactionAttributeType.REQUIRED)
	//TODO Cual es el resultado si no se aplica la transaccion pero si la necesita
	public void modificarComic(Long id, String nombre, ComicDTO comicNuevo) {
		Comic comicModificar;
		if (comicNuevo == null) { // no llego el dto con toda la informacion del comic entonces toca buscarlo
			comicModificar = em.find(Comic.class, id);//select * from comic, es lo que realiza por debajo
		}else { // si el comic nuevo llega, se necesita transformar la informacion
			comicModificar = convertirComicDTOtoComic(comicNuevo);
		}//TODO Hacer la validacion si el comic a modificar llego con datos
		comicModificar.setNombre(nombre);
		//si encuentra en la bd actualiza, sino inserta
		em.merge(comicModificar);
	}

	/**
	 *Este metodo es el encargado de eliminar un comic 
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarComic(Long idComic) {
		Comic comicEliminar;
		comicEliminar = em.find(Comic.class, idComic);
		em.remove(comicEliminar);
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComics() {
		List<ComicDTO> resultadosComicDTO = new ArrayList<ComicDTO>(); // conjunto de elementos que almacena datos con cierto orden
		List<Comic> resultados = em.createQuery("select c from Comic c").getResultList();// c hace referencia a toda la entidad
		for(Comic comic: resultados) {
			resultadosComicDTO.add(convertirComicToComicDTO(comic));
		}
		return resultadosComicDTO;
	}
	/**
	 * Metodo encargado para transpasar informacion de un lado a otro,
	 * no incluye manipulacion de datos
	 * SOLO los metodos (em) son los que necesitan transaccionalidad
	 * */
	private Comic convertirComicDTOtoComic (ComicDTO comicDTO ) {
		Comic comic = new Comic();
        if(comicDTO.getId()!=null) {
            comic.setId(Long.parseLong(comicDTO.getId()));
        }
        comic.setNombre(comicDTO.getNombre());
        comic.setEditorial(comicDTO.getEditorial());
        comic.setTematicaEnum(comicDTO.getTematica());
        comic.setColeccion(comicDTO.getColeccion());
        comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
        comic.setPrecio(comicDTO.getPrecio());
        comic.setAutores(comicDTO.getAutores());
        comic.setColor(comicDTO.getColor());
        comic.setFechaVenta(comicDTO.getFechaVenta());
        comic.setEstadoEnum(comicDTO.getEstado());
        comic.setCantidad(comicDTO.getCantidad());
        return comic;
	}
	
	private ComicDTO convertirComicToComicDTO(Comic comic) {
        ComicDTO comicDTO = new ComicDTO();
        if(comic.getId()!=null) {
         comicDTO.setId(comic.getId().toString());
        }
        comicDTO.setNombre(comic.getNombre());
        comicDTO.setEditorial(comic.getEditorial());
        comicDTO.setTematica(comic.getTematicaEnum());
        comicDTO.setColeccion(comic.getColeccion());
        comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
        comicDTO.setPrecio(comic.getPrecio());
        comicDTO.setAutores(comic.getAutores());
        comicDTO.setColor(comic.getColor());
        comicDTO.setFechaVenta(comic.getFechaVenta());
        comicDTO.setEstado(comic.getEstadoEnum());
        comicDTO.setCantidad(comic.getCantidad());
        return comicDTO;
    }
}
