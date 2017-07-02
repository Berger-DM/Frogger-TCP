package com.frogger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.IOException;
import java.util.Scanner;

public class HighScores {
    
    private Files file = new Files();
    public static final int MAX_SCORES = 10;
    public  String names[] = new String[MAX_SCORES];
    public  int scores[] = new int[MAX_SCORES];
    private String name;
    private int score;    
    
    public HighScores(){

        
    }
    
    public int getScore(int index){
        return this.scores[index];
    }
    
    public String getPlayerName(int index){
        return this.names[index];
    }
    
    public void setScore(int index, int score){
        this.scores[index] = score;
    }
    
    public void setPlayerName(int index, String name){
        this.names[index] = name;
    }
    
    public void initializesHighScores() throws FileNotFoundException{
        
        Scanner read = new Scanner (new File(file.filePath));
        read.useDelimiter(",");
        int i = 0;       
       
        
        while(read.hasNext() && i < MAX_SCORES){
            name = read.next();
            names[i] = name;
            score = Integer.parseInt(read.next());           
            scores[i] = score;
            i++;           
        }        
        read.close();  
        
       
    }
    
    public void updateHighScores(String name, int score){
        
        int i = 0;
        int auxScores[] = new int[MAX_SCORES];
        String auxNames[] = new String[MAX_SCORES];
        
        while(score < scores[i]){
            auxScores[i] = scores[i];
            auxNames[i] = names[i];
            i++;
        }
        
        auxScores[i] = score;
        auxNames[i] = name;
        i++;
        
        while(i < 10){
            auxScores[i] = scores[i-1];
            auxNames[i] = names[i-1];
            i++;
        }
        
        scores = auxScores;
        names = auxNames;
        
        //REMOVER
        
          for( i=0; i< 10; i++){
                    System.out.println(names[i] + "," + scores[i]);
          }   
        

    }
    
    
}
