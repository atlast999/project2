package model;

public class Track {
	private String fileName;
	private String content[] = {"One", "two", "three", "four", "five"};
	
	public Track() {
		this.fileName = "hi.mp3";
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String[] getContent() {
		return content;
	}
	public void setContent(String[] content) {
		this.content = content;
	}
	
	
}
