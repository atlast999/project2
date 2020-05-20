package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LevelController;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LevelChosing extends JFrame implements MouseListener {
	
	private static final long serialVersionUID = 1L;
	private LevelController controller;
	private JPanel contentPane;
	private JButton btnLevelOne , btnLevelTwo, btnLevelThree;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public LevelChosing() {
		controller = new LevelController();
		setLocationRelativeTo(null);
		setTitle("Practice English listening skills");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmDirection = new JMenuItem("Direction");
		mnHelp.add(mntmDirection);
		
		JMenuItem menuItem_1 = new JMenuItem("Exit");
		mnHelp.add(menuItem_1);
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		btnLevelOne = new JButton("Level 1");
		btnLevelOne.addMouseListener(this);
				
		btnLevelOne.setPreferredSize(new Dimension(200, 200));
		panel.add(btnLevelOne);
		
		
		btnLevelTwo = new JButton("Level 2");
		btnLevelTwo.setPreferredSize(new Dimension(200, 200));
		btnLevelTwo.addMouseListener(this);
		panel.add(btnLevelTwo);
		
		btnLevelThree = new JButton("Level 3");
		btnLevelThree.setPreferredSize(new Dimension(200, 200));
		btnLevelThree.addMouseListener(this);
		panel.add(btnLevelThree);
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent().equals(btnLevelOne)) {
			controller.moveToPracticing(1);
		}
		if(e.getComponent().equals(btnLevelTwo)) {
			controller.moveToPracticing(2);
		}
		if(e.getComponent().equals(btnLevelThree)) {
			controller.moveToPracticing(3);
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
