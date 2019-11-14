package com.hbt.semillero.servicios;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.hbt.semillero.pojo.EjerciciosPOJO;
/**
 * Esta clase es para realizar la maraton de programacion
 * @author Laura Elizabeth Castellanos Ducon 
 * */
public class EjerciciosTest {
	private EjerciciosPOJO ep;
	
	public EjerciciosTest() {
		this.ep = new EjerciciosPOJO();
	}
	
	/**
	 * Permitira probar si los numeros son o no primos
	 * */
	@Test(enabled = false)
	public void ejercicioPrimo() {
		int  opcion1 = 12;
		int  opcion2 = 21;
		int  opcion3 = 3;
		
		Assert.assertEquals(ep.isPrime(opcion1), false);
		Assert.assertEquals(ep.isPrime(opcion2), false);
		Assert.assertEquals(ep.isPrime(opcion3), true);
	}
	
	
}
