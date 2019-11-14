package com.hbt.semillero.servicios;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.hbt.semillero.pojo.EjerciciosPOJO;
import java.time.LocalDate;
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
	
	/**
	 * Permitira probar si 
	 * */
	@Test (enabled = false)
	public void ejercicio4() {
		LocalDate miFechaNacimiento = LocalDate.of(1997, 12, 20);
//		Assert.assertEquals(ep.ejercicio4(date 2019-11-13), false);
	}
	
}
