package controller;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Topic;
import model.Track;
import repository.Repo;

public class PracticingController {
	private ArrayList<Topic> listTopics;
	private Topic currentTopic;
	private long startingTime;
	private long finishingTime;
	
	public PracticingController(int level) {
		ArrayList<Topic> allTopics = Repo.getInstance().getListTopics();
		listTopics = new ArrayList<Topic>();
		for (Topic topic : allTopics) {
			if(topic.getLevel() == level) {
				listTopics.add(topic);
			}
		}
	}
	
	public void showTableListTopics(DefaultTableModel dtmListTopics) {
		for (Topic topic : listTopics) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(topic.getName());
			vec.add(topic.getLength());
			vec.add(topic.getDemostration());
			dtmListTopics.addRow(vec);
		}
	}
	
	public void setCurrentTopic(int row) {
		this.currentTopic = listTopics.get(row);
	}

	public void startPracticing(JTextField textFieldAnswer, JLabel lblTrack) {
		JOptionPane.showMessageDialog(null, "Practicing: " + currentTopic.getName());
		
		ArrayList<Track> listTracks = currentTopic.getTrackList();
		for (Track track : listTracks) {
			updateLabelTrack();
			playFile(track.getFileName());
			//TODO add event listener when textField changed
		}
	}
	
	private void updateLabelTrack() {
		// TODO update corresponding label
		
	}

	private void playFile(String fileName) {
		//TODO code for playing mp3 file
		JOptionPane.showMessageDialog(null, "Playing: " + fileName);
	}
}
