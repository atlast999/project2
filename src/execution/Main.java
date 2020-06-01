package execution;

import java.awt.EventQueue;

import utility.GraphPanel;
import view.LevelChosing;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelChosing frame = new LevelChosing();
					frame.setVisible(true);
//					new GraphPanel().createAndShowGui();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
