import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.application.Platform;

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

import java.util.Random;

/**
Class to control CharacterSheet scene
*/

public class CharacterSheetController implements Initializable {

   @FXML
   private Label CONModifier;

   @FXML
   private Label DEXModifier;

   @FXML
   private Label INTModifier;

   @FXML
   private Label RIZZModifier;

   @FXML
   private Label STRModifier;

   @FXML
   private Label WISModifier;

   @FXML
   private Label armorClass;

   @FXML
   private Button backButton;

   @FXML
   private Label characterName;

   @FXML
   private Label classLevel;

   @FXML
   private Button deleteButton;

   @FXML
   private Button diceRollScreenButton;

   @FXML
   private Label dndClass;

   @FXML
   private Label initiativeBonus;

   @FXML
   private Label race;

   @FXML
   private Label weaponName;
   
   @FXML
   void goToDiceRoller(ActionEvent event) {
   
   }
   
   @Override
   public void initialize(URL location, ResourceBundle resources) {
   
   }

}
