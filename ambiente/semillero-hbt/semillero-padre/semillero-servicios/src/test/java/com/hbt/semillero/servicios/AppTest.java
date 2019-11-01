package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;
import com.hbt.semillero.pojo.GestionarComicPOJO;

/**
 * Test unitario del semillero HBT
 * 
 * @author ccastano
 *
 */
public class AppTest {

	/**
	 * Metodo que permite validar si dada la suma de dos numero el resultado es el
	 * correcto
	 */
	@Test(enabled = false)
	public void primeraPU() {
		Long resultadoEsperado = 2159L;
		Long sumando1 = 1500L;
		Long sumando2 = 659L;
		Long resultado = sumando1 + sumando2;
		Assert.assertEquals(resultado, resultadoEsperado);
	}

	/**
	 * 
	 * Metodo encargado de dada una cadena invertir su posicion y retornarla al
	 * revez
	 * 
	 * @param cadena
	 * @return
	 */
	private String invertirCadena(String cadena) {
		String cadenaInvertida = "";
		for (int x = cadena.length() - 1; x >= 0; x--) {
			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		}
		return cadenaInvertida;
	}

	/**
	 * 
	 * Metodo encargado de validar que se invierte la cadena correctamente Se pone
	 * en mayusculas las cadenas Se quitan espacio al inicio y al fin de la cadena
	 * Se reemplazan espacios para que la validacion se pueda comprobar <b>Caso de
	 * Uso</b>
	 *
	 */
	@Test(enabled = false)
	public void invertirCadenaTest() {
		String resultado = invertirCadena("Yo soy");
		String actual = resultado.toUpperCase().trim();
		String esperado = "Yo soy".toUpperCase().trim();
		Assert.assertEquals(actual.replace(" ", ""), esperado.replace(" ", ""));
	}

	/**
	 * metodo para validar si la cadena invertida es la correcta
	 * 
	 */
	@Test(enabled = false)
	public void testInvert() {
		String word = "laura";

		String resultadoEsperado = " " + word;
		String resultadoEsperado2 = word + " ";
		String resultadoEsperado3 = word;
		String resultadoEsperado4 = "";
		String resultadoEsperado5 = "arual";

		Assert.assertEquals(invertirCadena(word), resultadoEsperado);
		Assert.assertEquals(invertirCadena(word), resultadoEsperado2);
		Assert.assertEquals(invertirCadena(word), resultadoEsperado3);
		Assert.assertEquals(invertirCadena(word), resultadoEsperado3);
		Assert.assertEquals(invertirCadena(word), resultadoEsperado3);
	}

	/**
	 * método que use el método ToString de la entidad comic
	 */
	@Test(enabled = false)
	public void testToString() {
		Comic comic = new Comic();
		comic.setNumeroPaginas(23);
		String numeroUnoPrueba = "23";
		String numeroDosPrueba = " 23";
		String numeroTresPrueba = "23 ";
		Assert.assertEquals(comic.getNumeroPaginas().toString(), numeroUnoPrueba);
		Assert.assertEquals(comic.getNumeroPaginas().toString(), numeroDosPrueba);
		Assert.assertEquals(comic.getNumeroPaginas().toString(), numeroTresPrueba);
	}

	/**
	 * Este metodo se encargara de probar el enumerado de EstadoEnum
	 */
	@Test(enabled = false)
	public void testEstadoEnum() {

		EstadoEnum estado1 = EstadoEnum.ACTIVO;
		EstadoEnum estado2 = EstadoEnum.INACTIVO;

		String variableActiva = "ACTIVO";
		Assert.assertEquals(estado1.name(), variableActiva);

		String variableInactiva = "INACTIVO";
		Assert.assertEquals(estado2, variableInactiva);
	}

	/**
	 * Devolver un entero con la posición del enum según está declarada
	 */
	@Test(enabled = false)
	public int posisionEnum(int position) {
		EstadoEnum estado1 = EstadoEnum.ACTIVO;
		EstadoEnum estado2 = EstadoEnum.INACTIVO;
		position = 1;
		ArrayList<String> listaEnum = new ArrayList<String>();
		listaEnum.add("" + estado1);
		listaEnum.add("" + estado2);

		Assert.assertEquals(listaEnum.get(1), position);
		return position;
	}

	/*
	 * devolver un array con todos los enum
	 */
	public void returnValues() {
		EstadoEnum estado1 = EstadoEnum.ACTIVO;
		EstadoEnum estado2 = EstadoEnum.INACTIVO;
		ArrayList<String> listaEnum = new ArrayList<String>();
		listaEnum.add("" + estado1);
		listaEnum.add("" + estado2);
		for (int i = 0; i < listaEnum.size(); i++) {
			System.out.println(listaEnum.get(i));
		}
	}

	

	/**
	 * se evaluara
	 */
	@Test
	public void agregarComicDTOLista() {

	}

}
