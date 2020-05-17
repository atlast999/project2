package model;

import java.util.ArrayList;

import repository.DatabaseInteraction;

public class Topic {
	private int level;
	private int topicId;

	private String name;
	//TODO should be long
	private int length;
	private String description = "xxxxxxxxxxxxx";
	private ArrayList<Track> trackList;
	
	public Topic(String name, String description, int level) {
		this.level = level;
		this.name = name;
		this.description = description;
		//TODO not like this
		trackList = new ArrayList<Track>();
		trackList = DatabaseInteraction.getInstance().getTrackByTopic(topicId);
	}

	public Topic() {

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

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descripton) {
		this.description = descripton;
	}

	public ArrayList<Track> getTrackList() {
		return trackList;
	}

	public void setTrackList(ArrayList<Track> trackList) {
		this.trackList = trackList;
	}
	
	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
		trackList = new ArrayList<Track>();
		trackList = DatabaseInteraction.getInstance().getTrackByTopic(topicId);
	}

}
