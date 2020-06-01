package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

import model.Topic;
import model.Track;
import utility.Util;

public class DatabaseInteraction {
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=OOP";
	private static final String USER = "sa";
	private static final String PASSWORD = "123456";
	
	private static DatabaseInteraction instance;
	private Connection c;
	
	public static DatabaseInteraction getInstance() {
		if(instance == null) {
			instance = new DatabaseInteraction();
		}
		return instance;
	}
	
	public DatabaseInteraction() {
		c = openConnection();
	}
	
	private Connection openConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
    public ArrayList<Topic> getAllTopic() {
    	ArrayList<Topic> list = new ArrayList<>();
        String select = "select * from topic";
        try (
            PreparedStatement ps = c.prepareStatement(select)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	Topic topic = new Topic();
            	topic.setTopicId(rs.getInt("topicId"));
            	topic.setLength(rs.getInt("length"));
            	topic.setName(rs.getString("name"));
            	topic.setDescription(rs.getString("description"));
            	topic.setLevel(rs.getInt("level"));
                list.add(topic);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<Track> getTrackByTopic(int topicId) {
    	ArrayList<Track> list = new ArrayList<>();
        String select = "select * from track where topicId=?";
        try (
            PreparedStatement ps = c.prepareStatement(select)) {
            ps.setInt(1, topicId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	Track track = new Track();
            	track.setFileName(rs.getString("fileName"));
            	track.setTrackId(rs.getInt("trackId"));
            	track.setScripts(Util.convertStringToArray(rs.getString("script")));
            	track.setFreeWords(Util.convertStringToArray(rs.getString("freeWord")));
                list.add(track);
            }
        } catch (Exception e) {
        }
        return list;
    }

	public LinkedList<Double> getScoreListByLevel(int level) {
		LinkedList<Double> list = new LinkedList<Double>();
		String select = "select top 30 * from score where level=? order by created_at desc";
		try {
			PreparedStatement ps = c.prepareStatement(select);
			ps.setInt(1, level);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.addFirst(rs.getDouble("value"));
			}
		} catch (Exception e) {
		}
//		System.out.println(list.toString());
		return list;
	}

	public void addNewScore(int currentLevel, long score) {
		String insert = "insert into score(level,value) values (" + currentLevel + "," + score + ")";
		try {
			PreparedStatement ps = c.prepareStatement(insert);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
