package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.servicios.EstadoEnum;

/**
 * Test unitario del semillero HBT
 * 
 * @author laura Elizabeth Castellanos Ducon
 *
 */
public class AppTest {

	/**
	 * Metodo que permite validar si dada la suma de dos numero el resultado es el
	 * correcto
	 */
	@Test
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
	 * metodo para validar si la cadena invertida es la correcta
	 * 
	 * */
	public void testInvert() {
		String word ="laura";
	
		String resultadoEsperado= " "+word;
		String resultadoEsperado2= word+" ";
		String resultadoEsperado3= word;
		String resultadoEsperado4= "";
		String resultadoEsperado5= "arual";
		
		if(invertirCadena(word).equals(resultadoEsperado)) {
			Assert.assertEquals(invertirCadena(word), resultadoEsperado);
		}
		if(invertirCadena(word).equals(resultadoEsperado2)) {
			Assert.assertEquals(invertirCadena(word), resultadoEsperado2);
		}
		if (invertirCadena(word).equals(resultadoEsperado3)) {
			Assert.assertEquals(invertirCadena(word), resultadoEsperado3);
		}
		if (invertirCadena(word).equals(resultadoEsperado4)) {
			Assert.assertEquals(invertirCadena(word), resultadoEsperado3);
		}
		if (invertirCadena(word).equals(resultadoEsperado5)) {
			Assert.assertEquals(invertirCadena(word), resultadoEsperado3);
		}
	}
	

}
