package com.tfa.retriever;


import org.apache.commons.lang.StringUtils;

public class Validaciones {

	public static String cadena(String cadena1, String cadena2) {
		if ((cadena1 != null) && (!StringUtils.isEmpty(cadena1)))
			return cadena1;
		return cadena2;
	}
	
	public static int entero(Integer num1, int num2) {
		if ((num1 != null))
			return num1;
		return num2;
	}

}
