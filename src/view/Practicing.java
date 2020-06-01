package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import controller.PracticingController;
import utility.GraphPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.Component;

public class Practicing extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PracticingController controller;
	private DefaultTableModel dtmListTopics;
	
	private JPanel contentPane;
	private JTable tableListTopics;
	private JTextField textFieldAnswer;
	private JLabel lblTrack;
	private JLabel lblScore;
	private JTextArea lblContentTrack;
	private JButton btnPlay;
	private JPanel panelScore;
	public Practicing(int level) {
		controller = new PracticingController(level);
		
		setLocationRelativeTo(null);
		setTitle("Practice listening level "+level);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPaneTopicsAndPracticing = new JSplitPane();
		splitPaneTopicsAndPracticing.setResizeWeight(0.9);
		splitPaneTopicsAndPracticing.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPaneTopicsAndPracticing, BorderLayout.CENTER);
		
		JPanel panelTopicList = new JPanel();
		//contentPane.add(panelTopicList, BorderLayout.CENTER);
		splitPaneTopicsAndPracticing.setLeftComponent(panelTopicList);
		panelTopicList.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("List of topics");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelTopicList.add(lblNewLabel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		panelTopicList.add(scrollPane, BorderLayout.CENTER);
		
		
		dtmListTopics = new DefaultTableModel();
		dtmListTopics.addColumn("Name");
		dtmListTopics.addColumn("Length");
		dtmListTopics.addColumn("Description");
		tableListTopics = new JTable(dtmListTopics);
		scrollPane.setViewportView(tableListTopics);
		//show table
		controller.showTableListTopics(dtmListTopics);
		//add event listener when user choose a topic
		tableListTopics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableListTopics.getSelectedRow();
				controller.setCurrentTopic(row);
			}
		});
		JButton btnGo = new JButton("Let's go");
		//add event listener when user click this button
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.startPracticing(textFieldAnswer, lblTrack, lblScore, lblContentTrack, btnPlay);
			}
		});
		panelTopicList.add(btnGo, BorderLayout.SOUTH);
		
		
		//----------------------------------------------------------------	
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.4);
//		contentPane.add(splitPane, BorderLayout.SOUTH);
		splitPaneTopicsAndPracticing.setRightComponent(splitPane);
		
		JPanel panelPracticing = new JPanel();
		splitPane.setLeftComponent(panelPracticing);
		panelPracticing.setLayout(new BorderLayout(0, 0));
		
		lblTrack = new JLabel("Track: 0 of xx");
		lblTrack.setHorizontalAlignment(SwingConstants.CENTER);
		panelPracticing.add(lblTrack, BorderLayout.NORTH);
		
		textFieldAnswer = new JTextField();
		textFieldAnswer.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				controller.handleEnteredAnswer(textFieldAnswer);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				//JOptionPane.showMessageDialog(null, "changed");
			}
		});
		panelPracticing.add(textFieldAnswer, BorderLayout.SOUTH);
		textFieldAnswer.setColumns(20);
		
		JPanel panel = new JPanel();
		panelPracticing.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblContentTrack = new JTextArea("answer:");
		panel.add(lblContentTrack, BorderLayout.NORTH);
		
		btnPlay = new JButton("Play");
		//when user click play/pause
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.handlePlayPauseButton();
			}
		});
		btnPlay.setAlignmentY(Component.TOP_ALIGNMENT);
		
		panel.add(btnPlay);
		
		panelScore = new JPanel();
		splitPane.setRightComponent(panelScore);
		panelScore.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Your score");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelScore.add(lblNewLabel_1, BorderLayout.NORTH);
		
		lblScore = new JLabel("xx");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		panelScore.add(lblScore, BorderLayout.CENTER);
		
		JButton btnViewChart = new JButton("View Chart");
		btnViewChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.showChart();
			}
		});
		panelScore.add(btnViewChart, BorderLayout.SOUTH);
		
		
	}

}
