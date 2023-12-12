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

public class OpeningSceneController {

   @FXML
   private Label Char1ClassLevel;

   @FXML
   private Label char1Class;

   @FXML
   private Button char1NameButton;

   @FXML
   private Label char1Race;

   @FXML
   private Button createNewCharacterButton;



   @FXML
   void goToEditChar(ActionEvent event)throws IOException {
    
      Parent root = FXMLLoader.load(getClass().getResource("newcharscreen.fxml"));
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      Scene newCharScene = new Scene(root);
      stage.setScene(newCharScene);
      stage.show();
   
   }

   @FXML
   void goToDiceRoller(ActionEvent event) throws IOException {
      
      Parent root = FXMLLoader.load(getClass().getResource("dicerollScreen.fxml"));
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      Scene diceRollerScene = new Scene(root);
      stage.setScene(diceRollerScene);
      stage.show();
   }

}
