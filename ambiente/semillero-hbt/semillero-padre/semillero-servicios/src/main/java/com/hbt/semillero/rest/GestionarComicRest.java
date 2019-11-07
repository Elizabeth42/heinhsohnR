package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
/**
 * <b>Descripcion: Utilizamos gestionar comic bean con el mundo extterior
 * */
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;
@Path ("/GestionarComic/")
public class GestionarComicRest {
	@EJB
	private IGestionarComicLocal gestionarComicEJB;
	
	/*
	 * Es importante decirle cual verbo http vamos a usar
	 * */
	@GET //tipo de verbo http
	@Path("/saludo") // ruta de acceso unica para nuestro recurso 
	@Produces// define el tipo de recurso que se va a producir
	public String primerRest() {
		return "Hola Mundo";
	}
	//servicio que vaya y consulte el comic
	@GET
    @Path("/consultarComic")
    @Produces(MediaType.APPLICATION_JSON)
	//para especificarr que recibe un paramentro dentro de la URL Qqueryparam
	public ComicDTO consultarComic(@QueryParam("idComic") Long idComic) {
		if(idComic!=null) {
			return gestionarComicEJB.consultarComic(idComic.toString());
			
		}
		return null;
	}
}
