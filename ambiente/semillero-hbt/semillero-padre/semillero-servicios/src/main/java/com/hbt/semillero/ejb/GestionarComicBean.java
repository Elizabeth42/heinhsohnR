package com.hbt.semillero.ejb;

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
public class GestionarComicBean {

	@PersistenceContext
    private EntityManager em;
		
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		
		//TODO
		//llenar  todos los campos
		em.persist(comic);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(ComicDTO comicModificar) {
		Comic comic = new Comic();
		comic.setId(comicModificar.getId());
		em.merge(comic);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String id) {
		Comic comic = em.find(Comic.class,id);
		ComicDTO comicDTO = new ComicDTO(comic.getId(),comic.getNombre());
		return comicDTO;
	}
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarTodos(){
		em.createNativeQuery("SELECT c FROM Comic").getResultList();
		List<Comic> resultados = (List<Comic>) em.createQuery("select c from Comic").getResultList();
		return null;
	}
}
