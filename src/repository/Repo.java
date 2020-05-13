package repository;

import java.util.ArrayList;

import model.Topic;

public class Repo {
	private static Repo instance;
	private ArrayList<Topic> listTopics;
	
	
	public static Repo getInstance() {
		if(instance == null) {
			instance = new Repo();
		}
		return instance;
	}
	public Repo() {
		//get data from database, not yet, just hard coding
		initData();
	}
	
	private void initData() {
		listTopics = new ArrayList<Topic>();
		//hard code for testing
		for(int i = 0; i<5; i++) {
			listTopics.add(new Topic(1, "topic" + i));
			listTopics.add(new Topic(2, "topic" + i));
			listTopics.add(new Topic(3, "topic" + i));
		}
	}
	public ArrayList<Topic> getListTopics() {
		return listTopics;
	}
}
