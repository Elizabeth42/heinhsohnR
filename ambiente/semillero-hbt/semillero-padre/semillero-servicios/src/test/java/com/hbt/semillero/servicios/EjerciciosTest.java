package com.hbt.semillero.servicios;


import org.testng.annotations.Test;
import com.hbt.semillero.pojo.EjerciciosPOJO;
/**
 * Esta clase es para realizar la maraton de programacion
 * @author Laura Elizabeth Castellanos Ducon 
 * */
public class EjerciciosTest {
	private String brand;
	private boolean empty;
	
	/**
	 *Este ejercicio lanza un error pues el objeto WaterBottle 
	 *no exite como tal
	 **/
	@Test
	public static void ejercicio2() {
		WaterBottle wb = new WaterBottle();
		System.out.println("Empty =" + wb.empty);
		System.out.println(",Brand ="+ wb.brand);
		
	}
	public static void main(String[] args) {
			EjerciciosTest t = new EjerciciosTest();
			t.ejercicio2();
	}
}
