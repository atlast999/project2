package execution;

import java.awt.EventQueue;

import repository.DatabaseInteraction;
import view.LevelChosing;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelChosing frame = new LevelChosing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
//generate score for testing
//		for(int row = 1; row <= 28; row++){
//			 for(int level = 1; level <=3; level++) {
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//				}
//				double hs = 0.1*row + 3;
//				int score = (int) Math.round(15*Math.cos((hs*Math.PI)/3) + 65);
//				DatabaseInteraction.getInstance().addNewScore(level, score);
//			}
//		}
		
		
	}
}
