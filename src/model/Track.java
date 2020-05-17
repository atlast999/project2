package model;

public class Track {
	private int trackId;
	private String fileName;
	private String scripts[] = {"One", "two", "three", "four", "five"};
	private String freeWords[] = {"Alexa"};
	
	public Track() {
		
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getTrackId() {
		return trackId;
	}
	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}
	public String[] getScripts() {
		return scripts;
	}
	public void setScripts(String[] scripts) {
		this.scripts = scripts;
	}
	public String[] getFreeWords() {
		return freeWords;
	}
	public void setFreeWords(String[] freeWords) {
		this.freeWords = freeWords;
	}

	
	
}
