import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Node; 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;

import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

public class OpeningSceneController implements Initializable {

   @FXML
   private Label Char1ClassLevel; //declaring label for the character's level

   @FXML
   private Label char1Class; //declaring label for the character's class

   @FXML
   private Button char1NameButton; //declaring button to roll for the character

   @FXML
   private Label char1Race; //declaring label for the character's race

   @FXML
   private Button createNewCharacterButton; //declaring button to edit the character


   /**
   goToEditChar method
   enables the user to switch to the editing character screen
   @param event clicking the "Edit Character" button
   */
   @FXML
   void goToEditChar(ActionEvent event)throws IOException {
    
      Parent root = FXMLLoader.load(getClass().getResource("newcharscreen.fxml"));
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      Scene newCharScene = new Scene(root);
      stage.setScene(newCharScene);
      stage.show();
   
   }
   
   /**
   goToDiceRoller method
   enables the user to switch to the dice rolling/character viewing screen
   @param event clicking the Character button
   */
   @FXML
   void goToDiceRoller(ActionEvent event) throws IOException {
      
      Parent root = FXMLLoader.load(getClass().getResource("dicerollScreen.fxml"));
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      Scene diceRollerScene = new Scene(root);
      stage.setScene(diceRollerScene);
      stage.show();
   }
   
   /** 
   initialize Method
   initializes the lists with the ability options listed
   @param location
   @param resources */
   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
   
   }

}
