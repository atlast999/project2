package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LevelController;
import model.User;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class LevelChosing extends JFrame implements MouseListener {
	
	private static final long serialVersionUID = 1L;
	private LevelController controller;
	private JPanel contentPane;
	private JButton btnLevelOne , btnLevelTwo, btnLevelThree;
	private User currentUser;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public LevelChosing(User user) {
		this.currentUser = user;
		this.controller = new LevelController();
		
		setTitle("Practice English listening skills");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar);
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mnHelp);
		
		JMenuItem mntmDirection = new JMenuItem("Direction");
		mnHelp.add(mntmDirection);
		
		JMenuItem menuItem_1 = new JMenuItem("Exit");
		mnHelp.add(menuItem_1);
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		btnLevelOne = new JButton("Level 1 (Beginner)");
		btnLevelOne.addMouseListener(this);
				
		btnLevelOne.setPreferredSize(new Dimension(200, 200));
		panel.add(btnLevelOne);
		
		
		btnLevelTwo = new JButton("Level 2 (Intermediate)");
		btnLevelTwo.setPreferredSize(new Dimension(200, 200));
		btnLevelTwo.addMouseListener(this);
		panel.add(btnLevelTwo);
		
		btnLevelThree = new JButton("Level 3 (Advanced)");
		btnLevelThree.setPreferredSize(new Dimension(200, 200));
		btnLevelThree.addMouseListener(this);
		panel.add(btnLevelThree);
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent().equals(btnLevelOne)) {
			controller.moveToPracticing(1, currentUser);
		}
		if(e.getComponent().equals(btnLevelTwo)) {
			controller.moveToPracticing(2, currentUser);
		}
		if(e.getComponent().equals(btnLevelThree)) {
			controller.moveToPracticing(3, currentUser);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
