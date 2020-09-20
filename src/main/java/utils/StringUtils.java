package utils;

import java.nio.charset.Charset;
import java.util.Random;

public class StringUtils {

	public static boolean isEmpty(String s) {
		boolean result = false;
		if(s == null) {
			result = true;
		}else if(s.equals("")) {
			result = true;
		}
		return result;
	}
	
	public static boolean isNotEmpty(String s) {
		boolean result = false;
		if(s != null && !s.equals("")) {
			result = true;
		}
		return result;
	}
	
	public static String randomStringGen(int numeroLettere) {
		byte[] array = new byte[numeroLettere]; 
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
	    if(isNotEmpty(generatedString)) {
			return generatedString;
	    }else {
	    	return null;
	    }
	}
}
