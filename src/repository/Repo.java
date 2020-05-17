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
		//
		listTopics = DatabaseInteraction.getInstance().getAllTopic();
	}
	
	public ArrayList<Topic> getListTopics() {
		return listTopics;
	}
}
