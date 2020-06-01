package controller;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import model.Topic;
import model.Track;
import repository.Repo;
import utility.GraphPanel;
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
	private JLabel lblTrack, lblScore;
	JTextArea lblAnswer;
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

	public void startPracticing(JTextField textFieldAnswer, JLabel lblTrack, JLabel lblScore, JTextArea lblContentTrack, JButton btnPlay) {
		this.lblAnswer = lblContentTrack;
		this.lblTrack = lblTrack;
		this.btnPlay = btnPlay;
		this.lblScore = lblScore;
		this.startingTime = Util.getCurrentTime();
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
		
		if(Util.areWordsMatching(answer, target) || Util.isCurrentWordFree(target, currentTrack)) {
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
		if(currentWord % 13 == 0 ) {
			result += "\n";
		}
		lblAnswer.setText(result);
	}
	private void updateScoreLabel() {
		System.out.println(startingTime + " " + finishingTime);
		String result = Util.calculateScore(finishingTime - startingTime, currentTopic.getLength());
		lblScore.setText(result);
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
		this.finishingTime = Util.getCurrentTime();
		updateScoreLabel();
		JOptionPane.showMessageDialog(null, "Done topic");
	}

	public void showChart() {
		 List<Double> scores = new ArrayList<>();
	        Random random = new Random();
	        int maxDataPoints = 30;
	        int maxScore = 1;
	        for (int i = 0; i < maxDataPoints; i++) {
	            scores.add((double) random.nextDouble() * maxScore);
	        }
	        JPanel panelChart = new GraphPanel(scores);
	        panelChart.setPreferredSize(new Dimension(800, 600));
	        JFrame frame = new JFrame("DrawGraph");
	        frame.getContentPane().add(panelChart);
	        frame.pack();
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	}
}
