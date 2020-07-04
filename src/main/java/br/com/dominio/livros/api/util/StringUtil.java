package br.com.dominio.livros.api.util;

import java.lang.reflect.Field;

public class StringUtil {
	public static String addSpace(Integer space) {
		return String.format("%"+ space+ "s", "");
	}

	public static String addZero(Integer space) {
		return addZeroEsqueda(space, 0);
	}

	public static String addZeroEsqueda(Integer size, Integer value) {
		return String.format("%0"+ size +"d", value);
	}

	public static String addSpaceEsqueda(Integer space, String value) {
		return value + String.format("%"+ (space - value.length()) + "s", "");
	}
	
	public static String browseFields(Object receivedObject) {
		StringBuilder retorno = new StringBuilder();

        Field[] fields = receivedObject.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value;
			try {
				value = field.get(receivedObject);
				if (value != null) {					
					retorno.append(field.getName() + " = " + value + ",");					
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
        }
		return retorno.toString();
	}
	
	public static String excluirEspaco(Object campo) {
		String campoFormatado = (String) campo;
		return campoFormatado.trim();		
	}
}
