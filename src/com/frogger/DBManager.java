package com.frogger;

import java.sql.*;

public class DBManager {
	static Connection c;
	static Statement stmt;
	
	public static void connect(){
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:highscore.db");
			c.setAutoCommit(false);
		} catch (Exception e) {
		  System.err.println(e.getClass().getName() + ": " + e.getMessage());
		  System.exit(0);
		}
		System.out.println("Opened database succesfully");
	}
	
	public static void createTable(){
		try{
			stmt = c.createStatement();
			String sql = "CREATE TABLE highscore " +
						"(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
						"NAME TEXT NOT NULL, " + 
						"SCORE INTEGER NOT NULL);";
			
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Table created");
	}
	
	public static void getHighscores(Highscore[] highscore){
		int hsSize = highscore.length;
		int count_hs = 0;
		try{
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT NAME, SCORE FROM highscore ORDER BY SCORE DESC;");
			
			while (rs.next() && count_hs < 10){
				String name = rs.getString("name");
				int score = rs.getInt("score");
				
				highscore[count_hs].name = name;
				highscore[count_hs].score = score;
				
				count_hs ++;
			}
			
			stmt.close();
			rs.close();
			
		} catch(Exception e){
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
			
	}
	
	public static void updateHighscores(Highscore[] hs){
		
		try{
			stmt = c.createStatement();
			String sql = "DELETE FROM highscore";
			stmt.executeUpdate(sql);
			c.commit();
			
			stmt.close();
			
			for (int i = 0; i < hs.length; i++) {
				stmt = c.createStatement();
				String sql3 = "INSERT INTO highscore (NAME, SCORE) " + 
							  "VALUES ('" + hs[i].name + "', " + hs[i].score + ");";
				stmt.executeUpdate(sql3);
				stmt.close();
			}
			
			c.commit();
			
		} catch (Exception e){
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
}
