/*
Giulietta M
DNDBuddyMain
CIS11B - Final Project D&D Buddy
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.*;

public class DNDBuddyMain extends Application
{
   public static void main(String[] args)
   {
      launch(args);
   }
   
   @Override
   public void start(Stage stage) throws Exception
   {
      //load all scenes
      //Parent rootCharList = FXMLLoader.load(getClass().getResource("OpeningScene.fxml"));
      //Scene charListScene = new Scene(rootCharList);
     
      Parent root = FXMLLoader.load(getClass().getResource("dicerollScreen.fxml"));
      Scene diceRollerScene = new Scene(root);
     
      //Parent rootNewChar = FXMLLoader.load(getClass().getResource("newcharscreen.fxml"));
      //Scene newCharScene = new Scene(rootNewChar);
     
      stage.setTitle("Dice Roller");
      stage.setScene(diceRollerScene);
      stage.show();
   }
  
   @Override
   public void stop() 
   {
      System.out.println("Application Stopped");
   }

}