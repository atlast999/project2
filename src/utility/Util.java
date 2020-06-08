package utility;

import java.util.Calendar;

import model.Track;

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
//				newTarget = target.substring(0, target.length() - 1);
				target = target.substring(0, target.length() - 1);
			}
		}
		return answer.toLowerCase().contains(target.toLowerCase());
//		return answer.equalsIgnoreCase(target);
	}

	public static long getCurrentTime() {
		return Calendar.getInstance().getTimeInMillis()/1000;
	}

	public static long calculateScore(long x, int y) {
		double result = 10 * (11 - (double)x/y);
		return Math.round(result);
	}

	public static boolean isCurrentWordFree(String target, Track currentTrack) {
		for(String word : currentTrack.getFreeWords()) {
			if(target.equalsIgnoreCase(word)) {
				return true;
			}
		}
		return false;
	}
}
