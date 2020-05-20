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
import utility.Util;

public class PracticingController {
	private ArrayList<Topic> listTopics;
	private Topic currentTopic;
	private int currentTrackNumber;
	private int currentWord;
	private int currentChar;
	private long startingTime;
	private long finishingTime;
	private boolean isPlaying;
	private boolean isCurrentTrackFinished;
	private boolean isCurrentTopicFinished;
	private SoundPlayer player;
	private JLabel lblTrack, lblAnswer;
	private JButton btnPlay;
	
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
			vec.add(Util.convertSecondToString(topic.getLength()));
			vec.add(topic.getDescription());
			dtmListTopics.addRow(vec);
		}
	}
	
	public void setCurrentTopic(int row) {
		this.currentTopic = listTopics.get(row);
	}

	public void startPracticing(JTextField textFieldAnswer, JLabel lblTrack, JLabel lblScore, JLabel lblAnswer, JButton btnPlay) {
		this.lblAnswer = lblAnswer;
		this.lblTrack = lblTrack;
		this.btnPlay = btnPlay;
		JOptionPane.showMessageDialog(null, "You are ready for practicing: " + currentTopic.getName());
		currentTrackNumber = 0;
		updateLabelTrack();
		playFile(currentTrackNumber);
	}
	
	public void handlePlayPauseButton() {
		if(isCurrentTrackFinished && !isCurrentTopicFinished) {
			currentTrackNumber++;
			updateLabelTrack();
			playFile(currentTrackNumber);
			return;
		}
		if(isPlaying) {
			btnPlay.setText("Play");
			player.suspend();
			isPlaying = false;
		} else {
			btnPlay.setText("Stop");
			player.resume();
			isPlaying = true;
		}
	}
	

	public void handleEnteredAnswer(JTextField textFieldAnswer) {
		Track currentTrack = currentTopic.getTrackList().get(currentTrackNumber);
		String target = currentTrack.getScripts()[currentWord];
		String answer = textFieldAnswer.getText();
		System.out.println(answer + " " + target + " " + currentChar);
		String previousAnswer = answer.substring(0, answer.length() - 1);
		currentChar = previousAnswer.length();
		if (Character.toLowerCase(answer.charAt(currentChar)) != Character.toLowerCase(target.charAt(currentChar))) {
			Runnable doAssist = new Runnable() {
	            @Override
	            public void run() {
	    			textFieldAnswer.setText(previousAnswer);
	            }
	        };
	        SwingUtilities.invokeLater(doAssist);
		}
		
		if(Util.areWordsMatching(answer, target)) {
			currentWord++;
			Runnable doAssist = new Runnable() {
	            @Override
	            public void run() {
	    			textFieldAnswer.setText("");
	    			updateLabelAnswer(target);
	    			if(currentWord >= currentTrack.getScripts().length) {
	    				handleTrackFinished();
	    			}
	            }
	        };
	        SwingUtilities.invokeLater(doAssist);
		}
	}
	
	
	
	private void updateLabelTrack() {
		String result = "Track: " + (currentTrackNumber+1) + " of " + currentTopic.getTrackList().size();
		lblTrack.setText(result);
	}
	private void updateLabelAnswer(String target) {
		if(target.equals("lola")) {
			lblAnswer.setText("Answer: ");
			return;
		}
		String result = lblAnswer.getText() + " " + target;
		lblAnswer.setText(result);
	}
	private void updateScoreLabel() {
		
	}
	private void playFile(int trackNumber) {
		//TODO code for playing mp3 file
		String fileName = currentTopic.getTrackList().get(trackNumber).getFileName();
		player = new SoundPlayer("WAV/" + fileName + ".wav");
		btnPlay.setText("Stop");
		player.start();
		isPlaying = true;
	}
	
	private void handleTrackFinished() {
		isCurrentTrackFinished = true;
		currentWord = 0;
		player.stop();
		updateLabelAnswer("lola");
		btnPlay.setText("Play next track");
		JOptionPane.showMessageDialog(null, "Done track");
		
		if(currentTrackNumber >= currentTopic.getTrackList().size() - 1) {
			handleTopicFinished();
		}
	}

	private void handleTopicFinished() {
		isCurrentTopicFinished = true;
		JOptionPane.showMessageDialog(null, "Done topic");
	}
}
