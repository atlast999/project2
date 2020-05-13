package model;

import java.util.ArrayList;

public class Topic {
	private int level;
	private String name;
	//TODO should be long
	private String length = "xx";
	private String demostration = "xxxxxxxxxxxxx";
	private ArrayList<Track> trackList;
	
	public Topic(int level, String name) {
		this.level = level;
		this.name = name;
		//TODO not like this
		trackList = new ArrayList<Track>();
		trackList.add(new Track());
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getDemostration() {
		return demostration;
	}

	public void setDemostration(String demostration) {
		this.demostration = demostration;
	}

	public ArrayList<Track> getTrackList() {
		return trackList;
	}

	public void setTrackList(ArrayList<Track> trackList) {
		this.trackList = trackList;
	}
	
	
}
