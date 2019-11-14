package com.hbt.semillero.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EjerciciosPOJO {

	/**
	 * Este ejercicio retornara si es divisor de un numero
	 * */
	public static boolean isDivisor (int dividend , int divisor) {
		boolean result = false;
		int residue = dividend %divisor;
		if(residue ==0);
			result = true;
			
		return result;	
	}
	
	/**
	 * Determinara si un numero es primo 
	 * */
	public  boolean isPrime (int number){
		boolean flag = false;
		int cont =2;
		
		while(cont <= number /2){
			if(isDivisor (number , cont)){
				flag= true;
			
				return false;
			} 
			cont ++;
		}		
		if(flag == false)
			return true;
		else
			return false;
	}
	
	/**
	 * se desea validar nuestra edad
	 * */
	public int ejercicio4 (LocalDate nacimiento, int anios) {
		int edad = 0;
		LocalDate now = LocalDate.now();
		edad = now.getYear()+ anios;
		return edad;
	}
	
	//-----------EJERCICIO 5
	/**
	 * 
	 **/
	public ArrayList<Integer> giveValue (String numeros,String separador) {	
		ArrayList<Integer> arrayNumeros = new ArrayList<Integer>();
		String[] stringNumeros = numeros.split(",");
		for (int i = 0; i < stringNumeros.length; i++) {
			arrayNumeros.add(Integer.parseInt(stringNumeros[i]));
		}
		return arrayNumeros;
	}
	
	public void organizar(ArrayList<Integer> cadena) {
		
	}
	
	//------------EJERCICIO 7
	/**
	 * permitira crear a los nuevos jugadores
	 * */
	public void setTenis(int set1, String jugador) {
		Map<Integer, String> jugador1 = new HashMap<Integer, String>();
		Map<Integer, String> jugador2 = new HashMap<Integer, String>();
	}
	
	//-------------EJERCICIO 8
	public ArrayList<Integer> gestionMonedas(int total){
		ArrayList<Integer> monedasPosibles = new ArrayList<Integer>();
		ArrayList<Integer> vueltas = new ArrayList<Integer>();
		int comparacion = 0; //llevara el calculo de cuantas vueltas llevamos
		monedasPosibles.add(1000);
		monedasPosibles.add(500);
		monedasPosibles.add(200);
		monedasPosibles.add(100);
		monedasPosibles.add(50);
		while (comparacion < total) {
			int i = 0;
				while(monedasPosibles.get(i)<total) {
					if (monedasPosibles.get(i)<total) {
						comparacion+=monedasPosibles.get(i);
						vueltas.add(monedasPosibles.get(i));
						total-=monedasPosibles.get(i);								
					}else {
					i++;
				}
			}
		}
		return vueltas;
	}

//-----------------EJERCICIO 9------------------
	/**
	 * ejercicio de completado de codigo con la correcta sintaxis de validaciones
	 * */
	//en la linea 7-B
	//en la linea 8- D
	public void ejercicio9() throws Exception{
		throw new Exception();
	}
	
	//-------------EJERCICIO 10 -----------
	
	
	
}
