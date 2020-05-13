package controller;

import view.Practicing;

public class LevelController {
	public void moveToPracticing(int level) {
		Practicing frame = new Practicing(level);
		frame.setVisible(true);
	}
}
