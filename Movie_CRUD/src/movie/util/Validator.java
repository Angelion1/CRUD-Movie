package movie.util;

import java.util.regex.Pattern;

public class Validator {
	public static boolean validateYear(String year) {
		boolean res = true;
		if (year != null) {
			res = Pattern.matches("^\\d{4}", year);
		}
		return res;
	}
	
	public static boolean validateRating(String rating) {
		boolean res = true;
		if (rating != null) {
			res = Pattern.matches("^\\d{1}", rating);
		}
		return res;
	}

}
