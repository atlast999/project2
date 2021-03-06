package controller;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

import model.Activity;
import model.Topic;
import model.Track;
import model.User;
import repository.DatabaseInteraction;
import repository.Repo;
import utility.GraphPanel;
import utility.SoundPlayer;
import utility.Util;
import view.History;
import view.Practicing;

public class PracticingController {
	private LinkedList<Double> listScores;
	private ArrayList<Topic> listTopics;
	private User currentUser;
	private int currentLevel;
	private Topic currentTopic;
	private int currentTrackNumber;
	private int currentWord;
	private int currentChar;
	private int currentHintNumber;
	private long startingTime;
	private long finishingTime;
	private boolean isPlaying;
	private boolean isCurrentTrackFinished;
	private boolean isCurrentTopicFinished;
	private SoundPlayer player;
	private JLabel lblTrack, lblScore;
	private JTextArea lblAnswer;
	private JButton btnPlay;
	private JTextField textFieldAnswer;
	private utility.Dictionary dictionary;

	
	public PracticingController(int level, LinkedList<Double> listScores, User user) {
		this.currentUser = user;
		this.dictionary = new utility.Dictionary();
		this.currentLevel = level;
		this.listScores = listScores;
		this.currentHintNumber = 10;
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
	
	public void setCurrentTopic(Topic curTopic) {
		this.currentTopic = curTopic;
	}

	public void startPracticing(JTextField textFieldAnswer, JLabel lblTrack, JLabel lblScore, JTextArea lblContentTrack, JButton btnPlay) {
		if(currentTopic == null) {
			JOptionPane.showMessageDialog(null, "Choose a topic, please!");
			return;
		}
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
	public void handleNextButton() {
		if(isCurrentTrackFinished && !isCurrentTopicFinished) {
			currentTrackNumber++;
			updateLabelTrack();
			playFile(currentTrackNumber);
			return;
		}
	}
	

	public void handleEnteredAnswer(JTextField textFieldAnswer) {
		this.textFieldAnswer = textFieldAnswer;
		Track currentTrack = currentTopic.getTrackList().get(currentTrackNumber);
		
		String target = currentTrack.getScripts()[currentWord];
		String answer = textFieldAnswer.getText();
		
		System.out.println(answer + " " + target + " " + currentChar);
		
		String previousAnswer = answer.substring(0, answer.length() - 1);
		currentChar = previousAnswer.length();

		
		if (Character.toLowerCase(answer.charAt(currentChar)) != Character.toLowerCase(target.charAt(currentChar))) {
			updateAnswerBox(previousAnswer);
		}
		
		if(Util.areWordsMatching(answer, target) || Util.isCurrentWordFree(target, currentTrack)) {
			currentWord++;
			updateLabelAnswer(target);
			if(currentWord >= currentTrack.getScripts().length) {
				handleTrackFinished();
			}
			updateAnswerBox("");
		}
	}
	
	private void updateAnswerBox(String text) {
		Runnable doAssist = new Runnable() {
            @Override
            public void run() {
    			textFieldAnswer.setText(text);
            }
        };
        SwingUtilities.invokeLater(doAssist);
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
		long result = Util.calculateScore(finishingTime - startingTime, currentTopic.getLength());
		handleScoreList(result);
		lblScore.setText("" + result);
	}
	private void handleScoreList(long result) {
		if(listScores.size() < 30) {
			listScores.addLast(1.0 * result);
		}else {
			listScores.removeFirst();
			listScores.addLast(1.0 * result);
		}
		DatabaseInteraction.getInstance().addNewScore(currentUser.getId(), currentLevel, currentTopic.getName(), result);
	}
	private void playFile(int trackNumber) {
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
			List<Double> scores = new ArrayList<>(listScores);
	        JPanel panelChart = new GraphPanel(scores);
	        panelChart.setPreferredSize(new Dimension(800, 600));
	        JFrame frame = new JFrame("The 30 most recent scores in level " + currentLevel);
	        frame.getContentPane().add(panelChart);
	        frame.pack();
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	}

	public void stopPracticing() {
		if(player != null) {
			player.stop();
		}
	}
	
	public void lookUpInDictionary(String keyword, JTextArea textResult) {
		StringBuilder result = new StringBuilder();
		ArrayList<String> res = dictionary.lookFor(keyword);
		if(res == null) {
			textResult.setText("Not found! Try another!");
			return;
		}
		for(int i = 0; i<res.size(); i++) {
			result.append(i+1);
			result.append(". ");
			result.append(res.get(i));
			result.append('\n');
		}
		textResult.setText(result.toString());
	}

	public void hint(JLabel labelHintNumber) {
		if(currentHintNumber <= 0) {
			return;
		}
		currentHintNumber--;
		labelHintNumber.setText("" + currentHintNumber);
		Track currentTrack = currentTopic.getTrackList().get(currentTrackNumber);
		updateAnswerBox(currentTrack.getScripts()[currentWord]);
	}

	public void showHistory(Practicing curPracticing) {
		ArrayList<Activity> listActivities = DatabaseInteraction.getInstance().getScoreListByUserId(currentUser.getId());
		History frame = new History(currentUser, listActivities, curPracticing);
		frame.setVisible(true);
	}
	
	public ArrayList<Topic> getListTopics() {
		return listTopics;
	}
	public Topic getTopicById(int topicId) {
		for(Topic topic : listTopics) {
			if(topic.getTopicId() == topicId) {
				return topic;
			}
		}
		return null;
	}

	
}
