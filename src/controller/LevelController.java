package controller;

import model.User;
import view.Practicing;

public class LevelController {
	public void moveToPracticing(int level, User user) {
		Practicing frame = new Practicing(level, user);
		frame.setVisible(true);
	}
}
