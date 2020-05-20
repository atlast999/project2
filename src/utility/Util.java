package utility;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Util {
	private static final char[] extraCharacter = {'.', ',', '?', ':'};
	public static String convertSecondToString(int second) {
		StringBuilder builder = new StringBuilder();
		builder.append(second / 60);
		builder.append(":");
		int sec = second % 60;
		if(sec < 10) {
			builder.append("0");
		}
		builder.append(second % 60);
		return builder.toString();
	}

	public static String[] convertStringToArray(String script) {
		return script.split(" ");
	}

	public static boolean areWordsMatching(String answer, String target) {
		for(char ch : extraCharacter) {
			if(ch == target.charAt(target.length() - 1)) {
				target = target.substring(0, target.length() - 2);
			}
		}
		return answer.equalsIgnoreCase(target);
	}
}
