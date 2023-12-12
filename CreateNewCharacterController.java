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

import java.util.Random;

   /**
   Class to control CreateNewCharacterSheet Scene
   */

public class CreateNewCharacterController implements Initializable {

   @FXML
   private Label armorClass;

   @FXML
   private Button backButton;

   @FXML
   private ComboBox<String> classDropDown;

   @FXML
   private Label initiativeBonus;

   @FXML
   private Label maxHP;

   @FXML
   private TextField nameInput;

   @FXML
   private ComboBox<String> raceDropDown;

   @FXML
   private TextField rawCHAScoreInput;

   @FXML
   private TextField rawCONScoreInput;

   @FXML
   private TextField rawDEXScoreInput;

   @FXML
   private TextField rawINTScoreInput;

   @FXML
   private TextField rawSTRScoreInput;

   @FXML
   private TextField rawWISScoreInput;

   @FXML
   private Button saveButton;

   @FXML
   private ComboBox<String> weaponsDropDown;
   
   @FXML
   private Button rollerButton;
   
   @FXML
   private Button abScoreButton;

   @FXML
   void saveCharacter(ActionEvent event) {
      //create CharacterSheet object
      CharacterSheet characterSheet = new CharacterSheet();
      
      //set CharacterSheet object to all fields user entered
      characterSheet.setName(nameInput.getText());
      characterSheet.setRace(raceDropDown.getValue());
      characterSheet.setDNDClass(classDropDown.getValue());
      //characterSheet.classLevel();
      characterSheet.setWeapon(weaponsDropDown.getValue());
   }
   
   @FXML
   void goToHomeScreen(ActionEvent event) throws IOException {

      Parent root = FXMLLoader.load(getClass().getResource("OpeningScene.fxml"));
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      Scene charListScene = new Scene(root);
      stage.setScene(charListScene);
      stage.show();   
   }
   
   
   @FXML
   void goToRoller(ActionEvent event) throws IOException {
      
      Parent root = FXMLLoader.load(getClass().getResource("dicerollScreen.fxml"));
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      Scene diceRollerScene = new Scene(root);
      stage.setScene(diceRollerScene);
      stage.show();
   }
   
   @FXML
   void generateAbScores(ActionEvent event) {
   
   }
   
   
   //Method for when race is edited, it shows the new racial bonus under the ability
   
   //Method for updating ArmorClass when class and CON ability score is changed
   
   @Override
   public void initialize(URL location, ResourceBundle resources) {
    //use to set the character's race/class/weapon selection
    
     //adding races to combobox
      String[] races = {"Dragonborn", "Dwarf", "Elf", "Gnome", "Half-Elf", "Halfling", "Half-Orc", "Human", "Tiefling"};
      raceDropDown.setItems(FXCollections.observableArrayList(races));
     
     //adding classes to combo box
      String[] dndClasses = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};
      classDropDown.setItems(FXCollections.observableArrayList(dndClasses));
     
     //adding weapons to combo box
      String[] weapons = {"Shortsword", "Longsword", "Shortbow", "Crossbow", "Dagger", "Club", "Waraxe", "Mace"};
      weaponsDropDown.setItems(FXCollections.observableArrayList(weapons));
   }

}
