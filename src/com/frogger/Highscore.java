package com.frogger;

public class Highscore {

	String name;
	int score;
	
	public Highscore(){
		this.name = "abc";
		this.score = 0;
	}
	
	public static void initializeHS(Highscore[] hs){
		for(int i = 0; i < hs.length; i++){
			hs[i] = new Highscore();
			System.out.println(i+1 + ". " + hs[i].name + " - " + hs[i].score);
		}
	}
	
	public static void updateHSArray(Highscore[] hs, String name, int score){
		hs[hs.length - 1].name = name;
		hs[hs.length - 1].score = score;
	}
}
