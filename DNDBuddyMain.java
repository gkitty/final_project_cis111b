/*
Giulietta and Margaret
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

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DNDBuddyMain extends Application
{
   public static void main(String[] args)
   {
      launch(args);
   }
   /**
   start method
   starts the stage
   @param stage the opening stage */
   @Override
   public void start(Stage stage) throws Exception
   {
      //load all scenes
      //Parent rootCharList = FXMLLoader.load(getClass().getResource("OpeningScene.fxml"));
      //Scene charListScene = new Scene(rootCharList);
     
      Parent root = FXMLLoader.load(getClass().getResource("OpeningScene.fxml"));
      Scene openingScene = new Scene(root);
     
      //Parent rootNewChar = FXMLLoader.load(getClass().getResource("newcharscreen.fxml"));
      //Scene newCharScene = new Scene(rootNewChar);
     
      stage.setTitle("DND Buddy");
      stage.setScene(openingScene);
      stage.show();
   }
  
   @Override
   public void stop() 
   {
      System.out.println("Application Stopped");
   }

}