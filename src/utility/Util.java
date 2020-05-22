package utility;

import java.util.Calendar;

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
		String newTarget = null;
		for(char ch : extraCharacter) {
			if(ch == target.charAt(target.length() - 1)) {
//				newTarget = target.substring(0, target.length() - 1);
				target = target.substring(0, target.length() - 1);
			}
		}
		return answer.equalsIgnoreCase(target);
	}

	public static long getCurrentTime() {
		return Calendar.getInstance().getTimeInMillis()/1000;
	}

	public static String calculateScore(long x, int y) {
		double result = 10 * (11 - (double)x/y);
		return "" + Math.round(result);
	}
}
