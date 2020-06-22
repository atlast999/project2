package model;

public class Activity {
	private String time;
	private int level;
	private String topicName;
	private int score;
	private int topicId;

	public Activity(String time, int level, String topicName, int score, int topicId) {
		super();
		this.time = time;
		this.level = level;
		this.topicName = topicName;
		this.score = score;
		this.topicId = topicId;
	}
	
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public Activity() {
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
