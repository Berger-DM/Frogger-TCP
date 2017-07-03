package com.frogger;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Files {


    public String filePath;
    public File highScoreFile;
  
    
    public Files(){
        this.filePath = "C:\\Users\\public\\highScores.txt";   
        this.highScoreFile = new File(filePath);       
    }
    
    public void createsFile(){
        
        try{
            highScoreFile.createNewFile();
        }catch(IOException e){
            System.out.println("Erro ao criar arquivo de scores");
        }
    }
    
    public void initializesScoresFile(){
         try (PrintWriter writer = new PrintWriter(filePath, "UTF-8")) {
            
                for(int i =0; i< 10; i++){
                    writer.println("..." + ",0,");
                }
             
        } catch (IOException e) {
                System.out.println("Erro ao escrever no arquivo");
        }
    }
    
    public void updatesScoresFile(String names[],int scores[]){
        
         try (PrintWriter writer = new PrintWriter(filePath, "UTF-8")) {
            
                for(int i =0; i< 10; i++){
                    writer.println(names[i] + "," + scores[i] + ",");
                }
             
        } catch (IOException e) {
                System.out.println("Erro ao escrever no arquivo");
        }
    }
    
    public boolean exists(){
            
            if(highScoreFile.exists()){
                return true;
            }
            else{
                return false;
            }                    
    }
    
    
}
