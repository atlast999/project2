package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.User;
import repository.DatabaseInteraction;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;

	public Login() {
		
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(20, 132, 77, 23);
		contentPane.add(lblUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(107, 133, 125, 20);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(20, 166, 77, 23);
		contentPane.add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(107, 164, 125, 20);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		ImageIcon icon1 = new ImageIcon("images/english.jpg");
		label_1.setIcon(icon1);
		label_1.setBounds(0, 0, 372, 136);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		ImageIcon icon = new ImageIcon(new ImageIcon("images/rabit.png").getImage().getScaledInstance(97, 72, Image.SCALE_DEFAULT));
		label.setIcon(icon);
		label.setBounds(275, 132, 97, 72);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("");
		ImageIcon icon2 = new ImageIcon(new ImageIcon("images/empty.jpg").getImage().getScaledInstance(372, 157, Image.SCALE_DEFAULT));
		label_2.setIcon(icon2);
		label_2.setBounds(0, 97, 372, 157);
		contentPane.add(label_2);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(91, 220, 77, 23);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(178, 220, 83, 23);
		contentPane.add(btnRegister);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processLogin();
			}
		});
	}

	protected void processLogin() {
		String username = textFieldUsername.getText();
		String password = textFieldPassword.getText();
		User user = DatabaseInteraction.getInstance().isLoginSuccessfull(username, password);
		//for testing
		if(username.equals(password)) {
			user = new User();
		}
		
		if(user == null) {
			JOptionPane.showMessageDialog(null, "Login failed, something wrong!");
			return;
		}
		LevelChosing frame = new LevelChosing(user);
		frame.setVisible(true);
		this.setVisible(false);
	}
}
