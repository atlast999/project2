package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Activity;
import model.Topic;
import model.User;
import repository.DatabaseInteraction;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class History extends JFrame {

	private JPanel contentPane;
	private JTable tableHistory, tableLeftover;
	private DefaultTableModel dtmActivities, dtmLeftover;
	private ArrayList<Activity> listActivities;
	private JScrollPane scrollPaneLeftover, scrollPane;
	private JButton btnReact;
	private User currentUser;
	private Practicing curPracticing;
	private ArrayList<Topic> listLeftovers;
	private boolean isReview;
	public History(User user, ArrayList<Activity> listActivities, Practicing currentPracticing) {
		this.isReview = true;
		this.listActivities = listActivities;
		this.currentUser = user;
		this.curPracticing = currentPracticing;
		this.listLeftovers = DatabaseInteraction.getInstance().getLeftoverTopic(currentUser.getId());
		setTitle("Recent activities of " + user.getName());
		setBounds(100, 100, 560, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		dtmActivities = new DefaultTableModel();
		dtmActivities.addColumn("Time");
		dtmActivities.addColumn("Level");
		dtmActivities.addColumn("Topic name");
		dtmActivities.addColumn("Score");
		tableHistory = new JTable(dtmActivities);
		scrollPane.setViewportView(tableHistory);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnReact = new JButton("Review");
		btnReact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPracticing.dispose();
				int selectedTopic;
				int currentLevel;
				if(isReview) {
					selectedTopic = listActivities.get(tableHistory.getSelectedRow()).getTopicId();
					currentLevel = listActivities.get(tableHistory.getSelectedRow()).getLevel();
					System.out.println(selectedTopic);
				} else {
					selectedTopic = listLeftovers.get(tableLeftover.getSelectedRow()).getTopicId();
					currentLevel = listLeftovers.get(tableLeftover.getSelectedRow()).getLevel();
				}
				processReviewFunction(selectedTopic, currentLevel);
				
			}

		});
		panel.add(btnReact);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnViewHistory = new JButton("History");
		btnViewHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				BorderLayout layout = (BorderLayout)contentPane.getLayout();
//				contentPane.remove(layout.getLayoutComponent(BorderLayout.CENTER));
				contentPane.remove(scrollPaneLeftover);
				contentPane.add(scrollPane, BorderLayout.CENTER);
				contentPane.validate();
				btnReact.setText("Review");
				isReview = true;
//				System.out.println("History button clicked");
			}
		});
		panel_1.add(btnViewHistory);
		
		JButton btnLeftover = new JButton("Leftover");
		btnLeftover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(scrollPane);
				contentPane.add(scrollPaneLeftover, BorderLayout.CENTER);
				contentPane.validate();
				btnReact.setText("Practice");
				isReview = false;
//				fillTableWithLeftover();
				
			}
		});
		panel_1.add(btnLeftover);
		dtmLeftover = new DefaultTableModel();
		dtmLeftover.addColumn("Level");
		dtmLeftover.addColumn("Topic");
		dtmLeftover.addColumn("Length");
		tableLeftover = new JTable(dtmLeftover);
		scrollPaneLeftover = new JScrollPane();
		scrollPaneLeftover.setViewportView(tableLeftover);
		
		
		
		fillTableWithActivities();
		fillTableWithLeftover();
	}
	private void fillTableWithLeftover() {
		for(Topic leftover : listLeftovers) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(leftover.getLevel());
			vec.add(leftover.getName());
			vec.add(leftover.getLength());
			dtmLeftover.addRow(vec);
		}
	}
	private void fillTableWithActivities() {
		for(Activity activity : listActivities) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(activity.getTime());
			vec.add(activity.getLevel());
			vec.add(activity.getTopicName());
			vec.add(activity.getScore());
			dtmActivities.addRow(vec);
		}
	}
	private void processReviewFunction(int selectedTopic, int currentLevel) {
		Practicing frame = new Practicing(currentLevel, currentUser);
		frame.init(selectedTopic);
		frame.setVisible(true);
		this.dispose();
	}
}
