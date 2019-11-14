package com.hbt.semillero.pojo;


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

}
