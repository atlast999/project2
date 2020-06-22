package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LevelController;
import model.User;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LevelChosing extends JFrame {

private static final long serialVersionUID = 1L;
	private LevelController controller;
	private JPanel contentPane;
	private JButton btnLevelOne , btnLevelTwo, btnLevelThree;
	private User currentUser;
	private JLabel lblNewLabel_1;

	public LevelChosing(User user) {
		this.currentUser = user;
		controller = new LevelController();
		setType(Type.UTILITY);
		setTitle("Practice English Litstening Skills");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Practice English Listening Skills application");
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(94, 24, 565, 52);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		btnLevelOne = new JButton("Level 1");
		btnLevelOne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.moveToPracticing(1, currentUser);
			}
				
		});
		btnLevelOne.setBackground(Color.ORANGE);
		btnLevelOne.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLevelOne.setForeground(Color.RED);
		btnLevelOne.setBounds(62, 181, 188, 72);
		contentPane.add(btnLevelOne);
		
		btnLevelTwo = new JButton("Level 2");
		btnLevelTwo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.moveToPracticing(2, currentUser);
			}
		});
		btnLevelTwo.setBackground(Color.ORANGE);
		btnLevelTwo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLevelTwo.setForeground(Color.RED);
		btnLevelTwo.setBounds(294, 182, 188, 72);
		contentPane.add(btnLevelTwo);
		
		btnLevelThree = new JButton("Level 3");
		btnLevelThree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.moveToPracticing(3, currentUser);
			}
		});
		btnLevelThree.setBackground(Color.ORANGE);
		btnLevelThree.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLevelThree.setForeground(Color.RED);
		btnLevelThree.setBounds(521, 185, 188, 66);
		contentPane.add(btnLevelThree);
		
		lblNewLabel_1 = new JLabel("Click to choose level");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.GREEN);
		lblNewLabel_1.setBounds(280, 67, 188, 81);
		contentPane.add(lblNewLabel_1);
	}
}
