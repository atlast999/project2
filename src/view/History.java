package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Activity;
import model.User;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class History extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtmActivities;
	private ArrayList<Activity> listActivities;
	public History(User user, ArrayList<Activity> listActivities) {
		this.listActivities = listActivities;
		setTitle("Recent activities of " + user.getName());
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		dtmActivities = new DefaultTableModel();
		dtmActivities.addColumn("Time");
		dtmActivities.addColumn("Level");
		dtmActivities.addColumn("Topic name");
		dtmActivities.addColumn("Score");
		table = new JTable(dtmActivities);
//		contentPane.add(table, BorderLayout.NORTH);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Review");
		panel.add(btnNewButton);
		
		fillTableWithActivities();
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

}
