package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;
import com.hbt.semillero.pojo.GestionarComicPOJO;

/**
 * Esta clase se encarga de realizar las pruebas unitarias de 
 * la clase de GestionarComicPOJOTest
 * @author Laura Elizabeth Castellanos Ducon 
 * */
public class GestionarComicPOJOTest {

	/**
	 * 
	 * */
	@Test(enabled = false)
	public void crearComicDTO() {
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
		gestionarComicPOJO.crearComicDTO();
		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() != 0);// preferiblemente usar el metodo de
																			// isEmpty()
		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());
	}

	@Test
	public void crearComicDTOTest() {
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
		//Creacion del primer comic- ostentara la posicion 0 en la lista 
		ComicDTO comicDTO = gestionarComicPOJO.crearComicDTO("101", "Captain America Corps 1-5 USA", "Panini Comics",
				TematicaEnum.FANTASTICO, "BIBLIOTECA MARVEL", 128, new BigDecimal(5000), "Phillippe Briones, Roger Stern ",
				Boolean.FALSE, LocalDate.now(), EstadoEnum.ACTIVO, 5L);
		
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
		
		Assert.assertNotNull(gestionarComicPOJO.getListaComics()); // para verificar que la lista no sea nula
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() != 0);// preferiblemente usar el metodo de is empty
		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty()); 
		
		//creacion del segundo comic - ostentara la posicion 1 en la lista 
		comicDTO = new ComicDTO();
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
		
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
		//Creacion del tercer comic - ostentara la posicion 2 en la lista 
		ComicDTO comicDTO2 = gestionarComicPOJO.crearComicDTO("102", "The Spectacular Spider-Man v2 USA", "Panini Comics",
				TematicaEnum.FANTASTICO, "MARVEL COMICS", 28, new BigDecimal(6225), "Straczynski,Deodato Jr.,Barnes,Eaton",
				Boolean.TRUE, LocalDate.now(), EstadoEnum.INACTIVO, 0L);
		gestionarComicPOJO.agregarComicDTOLista(comicDTO2);
		
//		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() > 1);
		
		//verificacion que se encuentran agregados tres comics y verificar como aumenta el tamaño cada que se agrega un nuevo comic
		Assert.assertEquals(gestionarComicPOJO.getListaComics().size(), 3);
		
		/*
		 * verificacion de modificar el comic id 102, cuyo nombre cambia a ser de The Spectacular Spider-Man v2 USA
		 * a El maravilloso hombre araña v2 USA
		 * Si la modificacion es satisfactoria la prueba no deberia presentar ningun error
		 * */
		Assert.assertEquals(gestionarComicPOJO.getListaComics().get(2).getNombre(), "The Spectacular Spider-Man v2 USA");
		gestionarComicPOJO.modificarComicDTO("102", "El maravilloso hombre araña v2 USA");
		Assert.assertEquals(gestionarComicPOJO.getListaComics().get(2).getNombre(), "El maravilloso hombre araña v2 USA");
		
		/*
		 * se desea eliminar el comic con id 101, para verificar que el cambio se realizo de forma satisfactoria 
		 * la prueba consiste en inicialmente comparar el nombre del primer elemento de la lista (id 101)
		 * "Captain America Corps 1-5 USA", posteriormente eliminarlo y proceder a validar el nombre de la primera
		 *  posicion que si el eliminarlo fue correcto, deberia ser equivalente a: "Dragon Ball Yamcha"
		 *  De funcionar correctamente la prueba sera satisfactoria
		 * */
		Assert.assertEquals(gestionarComicPOJO.getListaComics().get(0).getNombre(), "Captain America Corps 1-5 USA");
		gestionarComicPOJO.deleteComicDTO("101");
		Assert.assertEquals(gestionarComicPOJO.getListaComics().get(0).getNombre(), "Dragon Ball Yamcha");
	}
}
