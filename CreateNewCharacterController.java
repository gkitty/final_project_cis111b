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
   void saveCharacter(ActionEvent event) {
   
   }
   
   @FXML
   void goToHomeScreen(ActionEvent event) {
   
   }

   
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
