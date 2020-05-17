package controller;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import model.Topic;
import model.Track;
import repository.Repo;
import utility.SoundPlayer;

public class PracticingController {
	private ArrayList<Topic> listTopics;
	private Topic currentTopic;
	private Track currentTrack;
	private int currentTrackNumber;
	private int currentWord;
	private long startingTime;
	private long finishingTime;
	private boolean isPlaying;
	private boolean isCurrentTrackFinished;
	private SoundPlayer player;
	
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
			vec.add(topic.getDescription());
			dtmListTopics.addRow(vec);
		}
	}
	
	public void setCurrentTopic(int row) {
		this.currentTopic = listTopics.get(row);
	}

	public void startPracticing(JTextField textFieldAnswer, JLabel lblTrack, JLabel lblScore) {
		JOptionPane.showMessageDialog(null, "Practicing: " + currentTopic.getName());
		currentTrackNumber = 0;
		currentTrack = currentTopic.getTrackList().get(currentTrackNumber);
		playFile(currentTrack.getFileName());
	}
	
	public void handlePlayPauseButton(JButton btnPlay) {
		if(isCurrentTrackFinished) {
			currentTrackNumber++;
			currentTrack = currentTopic.getTrackList().get(currentTrackNumber);
			playFile(currentTrack.getFileName());
			return;
		}
		if(isPlaying) {
			player.suspend();
			isPlaying = false;
		} else {
			player.resume();
			isPlaying = true;
		}
	}
	
	
	private void updateLabelTrack() {
		// TODO update corresponding label
		
	}
	private void updateLabelAnswer() {
		//TODO
	}
	private void updateScoreLabel() {
		// TODO
		
	}
	private void playFile(String fileName) {
		//TODO code for playing mp3 file
		player = new SoundPlayer("WAV/" + fileName + ".wav");
		player.start();
		isPlaying = true;
	}

	public void handleEnteredAnswer(JTextField textFieldAnswer) {
		String answer = textFieldAnswer.getText();
		if(answer.equals(currentTrack.getScripts()[currentWord])) {
			currentWord++;
			Runnable doAssist = new Runnable() {
	            @Override
	            public void run() {
	    			textFieldAnswer.setText("");
	    			isCurrentTrackFinished = true;
	    			currentWord = 0;
	    			player.stop();
	            }
	        };
	        SwingUtilities.invokeLater(doAssist);
		}
	}

}
