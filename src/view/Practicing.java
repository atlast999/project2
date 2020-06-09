package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import controller.PracticingController;
import model.User;
import repository.Repo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.FlowLayout;

public class Practicing extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PracticingController controller;
	private DefaultTableModel dtmListTopics;
	
	private JPanel contentPane;
	private JTable tableListTopics;
	private JLabel lblTrack;
	private JLabel lblScore;
	private JTextArea lblContentTrack, textAreaResult;
	private JButton btnPlay;
	private JPanel panelScore;
	private LinkedList<Double> listScores;
	private boolean isPracticing;
	private JSplitPane splitPane_1;
	private JTextField textFieldKeyword;
	private JTextField textFieldAnswer;
	private JLabel labelHintNumber;
	public Practicing(int level, User user) {
		listScores = Repo.getInstance().getListScore(level);
		controller = new PracticingController(level, listScores, user);
		
		
		setTitle("Practice listening level "+level);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				controller.stopPracticing();
			}
		});
		setBounds(100, 100, 865, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JSplitPane splitPaneTopicsAndPracticing = new JSplitPane();
		splitPaneTopicsAndPracticing.setResizeWeight(0.9);
		splitPaneTopicsAndPracticing.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPaneTopicsAndPracticing, BorderLayout.CENTER);
		
		
		
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
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textFieldAnswer = new JTextField();
		textFieldAnswer.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				controller.handleEnteredAnswer(textFieldAnswer);
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		textFieldAnswer.setColumns(30);
		panel_2.add(textFieldAnswer);
		
		JButton btnHint = new JButton("Hint");
		btnHint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.hint(labelHintNumber);
			}
		});
		panel_2.add(btnHint);
		
		labelHintNumber = new JLabel("10");
		panel_2.add(labelHintNumber);
		
		panelScore = new JPanel();
		splitPane.setRightComponent(panelScore);
		panelScore.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Your score");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelScore.add(lblNewLabel_1, BorderLayout.NORTH);
		
		lblScore = new JLabel("xx");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		panelScore.add(lblScore, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panelScore.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnChart = new JButton("Chart");
		btnChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.showChart();
			}
		});
		panel_1.add(btnChart);
		
		JButton btnHistory = new JButton("History");
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.showHistory();
			}
		});
		panel_1.add(btnHistory);
		
		splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.9);
		splitPaneTopicsAndPracticing.setLeftComponent(splitPane_1);
		
		
		JPanel panelTopicList = new JPanel();
		//contentPane.add(panelTopicList, BorderLayout.CENTER);
		splitPane_1.setLeftComponent(panelTopicList);
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
				if(isPracticing) {
					JOptionPane.showMessageDialog(null, "Wanna give up?");
					controller.stopPracticing();
				}
				controller.startPracticing(textFieldAnswer, lblTrack, lblScore, lblContentTrack, btnPlay);
				isPracticing = true;
			}
		});
		panelTopicList.add(btnGo, BorderLayout.SOUTH);
		
		JPanel panelDictionary = new JPanel();
		splitPane_1.setRightComponent(panelDictionary);
		panelDictionary.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDictionary = new JLabel("Dictionary");
		lblDictionary.setHorizontalAlignment(SwingConstants.CENTER);
		panelDictionary.add(lblDictionary, BorderLayout.NORTH);
		
		JPanel panelSearch = new JPanel();
		panelDictionary.add(panelSearch, BorderLayout.CENTER);
		panelSearch.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panelSearch.add(panel_4, BorderLayout.NORTH);
		
		textFieldKeyword = new JTextField();
		panel_4.add(textFieldKeyword);
		textFieldKeyword.setColumns(10);
		
		JButton btnSearch = new JButton("GO");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.lookUpInDictionary(textFieldKeyword.getText(), textAreaResult);
			}
		});
		panel_4.add(btnSearch);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panelSearch.add(scrollPane_1, BorderLayout.CENTER);
		
		textAreaResult = new JTextArea();
		textAreaResult.setLineWrap(true);
		textAreaResult.setWrapStyleWord(true);
		scrollPane_1.setViewportView(textAreaResult);
		
		
		
	}

}
